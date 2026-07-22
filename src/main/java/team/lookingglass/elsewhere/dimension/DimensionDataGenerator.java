package team.lookingglass.elsewhere.dimension;

import com.google.gson.JsonElement;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Encoder;
import com.mojang.serialization.JsonOps;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.ResourceKey;

import java.nio.file.Path;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class DimensionDataGenerator implements DataProvider {
    private final PackOutput output;
    private final CompletableFuture<HolderLookup.Provider> registries;

    public DimensionDataGenerator(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        this.output = output;
        this.registries = registries;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        return registries.thenCompose(access -> {
            DynamicOps<JsonElement> registryOps = access.createSerializationContext(JsonOps.INSTANCE);
            return CompletableFuture.allOf(RegistryDataLoader.DIMENSION_REGISTRIES.stream()
                    .flatMap(v -> dumpRegistryCap(cache, access, registryOps, v).stream())
                    .toArray(CompletableFuture[]::new));
        });
    }

    private <T> Optional<CompletableFuture<?>> dumpRegistryCap(CachedOutput cache, HolderLookup.Provider registries,
                                                               DynamicOps<JsonElement> writeOps, RegistryDataLoader.RegistryData<T> v) {
        ResourceKey<? extends Registry<T>> registryKey = v.key();
        return registries.lookup(registryKey).map(registry -> {
            PackOutput.PathProvider pathProvider = output.createRegistryElementsPathProvider(registryKey);
            return CompletableFuture.allOf(registry.listElements()
                    .map(e -> dumpValue(pathProvider.json(e.key().identifier()), cache, writeOps, v.elementCodec(), e.value()))
                    .toArray(CompletableFuture[]::new));
        });
    }

    private static <E> CompletableFuture<?> dumpValue(Path path, CachedOutput cache, DynamicOps<JsonElement> ops,
                                                      Encoder<E> codec, E value) {
        return codec.encodeStart(ops, value).mapOrElse(
                result -> DataProvider.saveStable(cache, result, path),
                error -> CompletableFuture.failedFuture(
                        new IllegalStateException("Couldn't generate file '" + path + "': " + error.message())));
    }

    @Override
    public String getName() {
        return "Elsewhere Dimensions";
    }
}
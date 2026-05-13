package team.lookingglass.elsewhere.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import team.lookingglass.elsewhere.registry.EParticles;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ParticleProvider implements DataProvider {

    private final FabricPackOutput output;

    public ParticleProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        List<CompletableFuture<?>> futures = new ArrayList<>();
        futures.add(saveParticle(cache, EParticles.SULFUR_BUBBLES, true, "bubble", false, 1));
        futures.add(saveParticle(cache, EParticles.NOXIOUS_GAS, false,"noxious_gas", true, 8));
        futures.add(saveParticle(cache, EParticles.NOXIOUS_GAS_CLOUD, false,"noxious_gas", true, 8));
        futures.add(saveParticle(cache, EParticles.GEYSER_BASE, false,"geyser_base", true, 8));
        futures.add(saveParticle(cache, EParticles.GEYSER_POOF, false,"geyser_poof", true, 8));
        futures.add(saveParticle(cache, EParticles.GEYSER_PLUME, false,"geyser_plume", true, 8));
        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    private CompletableFuture<?> saveParticle(CachedOutput cache, ParticleType<?> type,  boolean vanilla, String name, boolean animated, int frames) {
        String namespace = vanilla ? "minecraft" : "elsewhere";
        JsonObject json = new JsonObject();
        JsonArray textures = new JsonArray();
        if (animated) {
            for (int i = 1; i <= frames; i++) {
                textures.add(namespace + ":" + name + "_" + String.format("%02d", i));
            }
        } else {
            textures.add(namespace + ":" + name);
        }
        json.add("textures", textures);
        Path path = output.getOutputFolder().resolve("assets/elsewhere/particles/" +
                BuiltInRegistries.PARTICLE_TYPE.getKey(type).getPath() + ".json");
        return DataProvider.saveStable(cache, json, path);
    }

    @Override
    public String getName() {
        return "Elsewhere Particles";
    }
}
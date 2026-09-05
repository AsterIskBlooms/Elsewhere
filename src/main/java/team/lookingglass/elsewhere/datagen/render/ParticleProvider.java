package team.lookingglass.elsewhere.datagen.render;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.Identifier;
import team.lookingglass.elsewhere.Elsewhere;
import team.lookingglass.elsewhere.registry.render.EParticles;

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
        futures.add(saveParticle(cache, EParticles.SULFUR_BUBBLES, true, "bubble"));
        futures.add(saveParticle(cache, EParticles.NOXIOUS_GAS, false, "noxious_gas", 8));
        futures.add(saveParticle(cache, EParticles.NOXIOUS_GAS_CLOUD, false, "noxious_gas", 8));
        futures.add(saveParticle(cache, EParticles.GEYSER_BASE, false, "geyser_base", 8));
        futures.add(saveParticle(cache, EParticles.GEYSER_POOF, false, "geyser_poof", 8));
        futures.add(saveParticle(cache, EParticles.GEYSER_PLUME, false, "geyser_plume", 8));
        futures.add(saveParticle(cache, EParticles.RED_POPLAR_LEAVES, false, "red_poplar", 4));
        futures.add(saveParticle(cache, EParticles.ORANGE_POPLAR_LEAVES, false, "orange_poplar", 4));
        futures.add(saveParticle(cache, EParticles.YELLOW_POPLAR_LEAVES, false, "yellow_poplar", 4));
        futures.add(saveParticle(cache, EParticles.GILDED_BIRCH_LEAVES, false, "gilded_birch", 4));
        futures.add(saveParticle(cache, EParticles.SULFUR_CUBE_PARTICLE, false, "sulfur_goo"));
        futures.add(saveParticle(cache, EParticles.SUBSLIME_PARTICLE, false, "subslime_goo"));


        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    private CompletableFuture<?> saveParticle(CachedOutput cache, ParticleType<?> type, boolean vanilla, String name) {
        String namespace = vanilla ? Identifier.DEFAULT_NAMESPACE : Elsewhere.MODID;
        JsonObject json = new JsonObject();
        JsonArray textures = new JsonArray();
        textures.add(namespace + ":" + name);
        json.add("textures", textures);
        Path path = output.getOutputFolder().resolve("assets/elsewhere/particles/" + BuiltInRegistries.PARTICLE_TYPE.getKey(type).getPath() + ".json");
        return DataProvider.saveStable(cache, json, path);
    }
    private CompletableFuture<?> saveParticle(CachedOutput cache, ParticleType<?> type, boolean vanilla, String name, int frames) {
        String namespace = vanilla ? Identifier.DEFAULT_NAMESPACE : Elsewhere.MODID;
        JsonObject json = new JsonObject();
        JsonArray textures = new JsonArray();
        for (int i = 1; i <= frames; i++) { textures.add(namespace + ":" + name + "_" + String.format("%02d", i)); }
        json.add("textures", textures);
        Path path = output.getOutputFolder().resolve("assets/elsewhere/particles/" + BuiltInRegistries.PARTICLE_TYPE.getKey(type).getPath() + ".json");
        return DataProvider.saveStable(cache, json, path);
    }

    @Override
    public String getName() {
        return "Elsewhere Particles";
    }
}
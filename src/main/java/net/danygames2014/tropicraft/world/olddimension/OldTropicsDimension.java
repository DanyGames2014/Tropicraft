package net.danygames2014.tropicraft.world.olddimension;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.EnvironmentInterface;
import net.minecraft.world.chunk.ChunkSource;
import net.minecraft.world.dimension.Dimension;
import net.modificationstation.stationapi.api.client.world.dimension.TravelMessageProvider;

import java.util.Random;

@EnvironmentInterface(value = EnvType.CLIENT, itf = TravelMessageProvider.class)
public class OldTropicsDimension extends Dimension implements TravelMessageProvider {
    public OldTropiNoiseSampler terrainNoise;
    public OldTropiNoiseSampler landBiomeNoise;
    public OldTropiNoiseSampler riverNoise;

    public OldTropicsDimension(int id) {
        this.id = id;
    }

    @Override
    protected void initBiomeSource() {
        terrainNoise = new OldTropiNoiseSampler(new Random(this.world.getSeed()), 5);
        landBiomeNoise = new OldTropiNoiseSampler(new Random(this.world.getSeed() + 13), 2);
        riverNoise = new OldTropiNoiseSampler(new Random(this.world.getSeed() + 18), 3, 0.4D, 1.5D);
        biomeSource = new OldTropicsBiomeSource(this.world, this);
    }
    
    @Override
    public String getEnteringTranslationKey() {
        return "dim.tropicraft.tropics.entering";
    }

    @Override
    public String getLeavingTranslationKey() {
        return "dim.tropicraft.tropics.leaving";
    }

    @Override
    public ChunkSource createChunkGenerator() {
        return new OldChunkProviderTropics(this.world, this.world.getSeed(), this);
    }


}

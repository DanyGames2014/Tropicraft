package net.danygames2014.tropicraft.world.dimension;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.EnvironmentInterface;
import net.minecraft.world.chunk.ChunkSource;
import net.minecraft.world.dimension.Dimension;
import net.modificationstation.stationapi.api.client.world.dimension.TravelMessageProvider;

import java.util.Random;

@EnvironmentInterface(value = EnvType.CLIENT, itf = TravelMessageProvider.class)
public class TropicsDimension extends Dimension implements TravelMessageProvider {
    public TropiNoiseSampler terrainNoise;
    public TropiNoiseSampler landBiomeNoise;
    public TropiNoiseSampler riverNoise;

    public TropicsDimension(int id) {
        this.id = id;
    }

    @Override
    protected void initBiomeSource() {
        terrainNoise = new TropiNoiseSampler(new Random(this.world.getSeed()), 5);
        landBiomeNoise = new TropiNoiseSampler(new Random(this.world.getSeed() + 13), 2);
        riverNoise = new TropiNoiseSampler(new Random(this.world.getSeed() + 18), 3, 0.4D, 1.5D);
        biomeSource = new TropicsBiomeSource(this.world, this);
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
        return new ChunkProviderTropics(this.world, this.world.getSeed(), this);
    }


}

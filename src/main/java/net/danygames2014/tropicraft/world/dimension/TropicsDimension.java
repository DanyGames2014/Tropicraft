package net.danygames2014.tropicraft.world.dimension;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.EnvironmentInterface;
import net.minecraft.world.chunk.ChunkSource;
import net.minecraft.world.dimension.Dimension;
import net.modificationstation.stationapi.api.client.world.dimension.TravelMessageProvider;

import java.util.Random;

@EnvironmentInterface(value = EnvType.CLIENT, itf = TravelMessageProvider.class)
public class TropicsDimension extends Dimension implements TravelMessageProvider {
    public Random random;
    
    public TropiNoiseSampler2D continentalNoise;
    public TropiNoiseSampler2D erosionNoise;
    public TropiNoiseSampler2D peakValleyNoise;
    public TropiNoiseSampler2D riverNoise;
    public TropiNoiseSampler2D biomeNoise;
    
    public TropiNoiseSampler3D terrainNoise;
    
    public TropicsDimension(int id) {
        this.id = id;
    }

    @Override
    protected void initBiomeSource() {
        random = new Random(this.world.getSeed());
        int seed = random.nextInt();
        
        continentalNoise = new TropiNoiseSampler2D(seed, 5, 0.5, 2.0);
        erosionNoise = new TropiNoiseSampler2D(seed + 1, 6, 0.45, 2.0);
        peakValleyNoise = new TropiNoiseSampler2D(seed + 2, 7, 0.45, 2.0);
        riverNoise = new TropiNoiseSampler2D(seed + 3, 2, 0.5, 2.0);
        terrainNoise = new TropiNoiseSampler3D(seed + 4, 5, 0.5, 2.0);
        
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

package net.danygames2014.tropicraft.world.dimension;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.EnvironmentInterface;
import net.minecraft.world.chunk.ChunkSource;
import net.minecraft.world.dimension.Dimension;
import net.modificationstation.stationapi.api.client.world.dimension.TravelMessageProvider;

@EnvironmentInterface(value = EnvType.CLIENT, itf = TravelMessageProvider.class)
public class TropicsDimension extends Dimension implements TravelMessageProvider {
    public TropicsDimension(int id) {
        this.id = id;
    }

    @Override
    protected void initBiomeSource() {
        biomeSource = new TropicsBiomeSource();
    }
    
    @Override
    public String getEnteringTranslationKey() {
        return "dim.tropicraft.tropics.entering";
    }

    @Override
    public String getLeavingTranslationKey() {
        return "dim.tropicraft.tropics.leaving";
    }

    // Chunk Provider
    @Override
    public ChunkSource createChunkGenerator() {
        return new ChunkProviderTropics(this.world, this.world.getSeed());
    }


}

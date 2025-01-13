package net.danygames2014.tropicraft.world.dimension;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.client.gui.screen.LoadingDisplay;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkSource;
import net.modificationstation.stationapi.impl.world.chunk.FlattenedChunk;

import java.util.Random;

public class ChunkProviderTropics implements ChunkSource {
    private final World world;
    public Random random;

    public ChunkProviderTropics(World world, long seed) {
        this.world = world;
        this.random = new Random(seed);
    }

    @Override
    public boolean isChunkLoaded(int x, int z) {
        return true;
    }

    @Override
    public Chunk loadChunk(int chunkX, int chunkZ) {
        return this.getChunk(chunkX, chunkZ);
    }

    @Override
    public Chunk getChunk(int chunkX, int chunkZ) {
        FlattenedChunk chunk = new FlattenedChunk(world, chunkX, chunkZ);

        for (int y = 0; y < 50; y++) {
            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    chunk.setBlockState(x, y, z, Tropicraft.bambooBundle.getDefaultState());
                }
            }
        }

        chunk.populateHeightMap();
        chunk.populateBlockLight();

        return chunk;
    }

    @Override
    public void decorate(ChunkSource source, int x, int z) {

    }

    @Override
    public boolean save(boolean flag, LoadingDisplay loadingDisplay) {
        return true;
    }

    @Override
    public boolean tick() {
        return false;
    }

    @Override
    public boolean canSave() {
        return true;
    }

    @Override
    public String getDebugInfo() {
        return "TropicsChunkSource";
    }
}

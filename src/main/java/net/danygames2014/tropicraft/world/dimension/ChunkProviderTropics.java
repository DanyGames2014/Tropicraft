package net.danygames2014.tropicraft.world.dimension;

import net.minecraft.client.gui.screen.LoadingDisplay;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkSource;

import java.util.Random;

public class ChunkProviderTropics implements ChunkSource { // class_51 = WorldSource
    public Random random;

    public ChunkProviderTropics(World world, long seed) {
        this.random = new Random(seed);
    }

    @Override
    public boolean isChunkLoaded(int x, int z) { // isChunkLoaded
        return false;
    }

    @Override
    public Chunk getChunk(int x, int z) { // provideChunk / getChunk
        return null;
    }

    @Override
    public Chunk loadChunk(int x, int z) { // prepareChunk / loadChunk
        return null;
    }

    @Override
    public void decorate(ChunkSource source, int x, int z) { // decorate / populate

    }

    @Override
    public boolean save(boolean flag, LoadingDisplay loadingDisplay) { // deleteCache
        return true;
    }

    @Override
    public boolean tick() { // unload100OldestChunks, validateEmpty
        return false;
    }

    @Override
    public boolean canSave() { // canSave, isClean, hasEntries
        return true;
    }

    @Override
    public String getDebugInfo() { // makeString / toString / getName / getDebugString
        return "TropicsChunkManager";
    }
}

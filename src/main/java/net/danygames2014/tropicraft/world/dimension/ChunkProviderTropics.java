package net.danygames2014.tropicraft.world.dimension;

import net.minecraft.class_51;
import net.minecraft.class_62;
import net.minecraft.world.chunk.Chunk;

public class ChunkProviderTropics implements class_51 { // class_51 = WorldSource
    @Override
    public boolean method_1802(int i, int j) { // isChunkLoaded
        return false;
    }

    @Override
    public Chunk method_1806(int i, int j) { // provideChunk / getChunk
        return null;
    }

    @Override
    public Chunk method_1807(int i, int j) { // prepareChunk / loadChunk
        return null;
    }

    @Override
    public void method_1803(class_51 arg, int i, int j) { // decorate / populate

    }

    @Override
    public boolean method_1804(boolean bl, class_62 arg) { // deleteCache
        return false;
    }

    @Override
    public boolean method_1801() { // unload100OldestChunks, validateEmpty
        return false;
    }

    @Override
    public boolean method_1805() { // canSave, isClean, hasEntries
        return false;
    }

    @Override
    public String method_1808() { // makeString / toString / getName
        return null;
    }
}

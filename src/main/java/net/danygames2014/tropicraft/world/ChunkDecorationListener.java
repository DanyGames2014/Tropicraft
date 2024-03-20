package net.danygames2014.tropicraft.world;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.event.world.gen.WorldGenEvent;

public class ChunkDecorationListener {
    @EventListener
    public void decorate(WorldGenEvent.ChunkDecoration event) {
        if (event.world.dimension.id == 0) {
            decorateOverworld(event);
        }
    }

    public void decorateOverworld(WorldGenEvent.ChunkDecoration event) {
        int x = event.x + event.random.nextInt(0, 15);
        int z = event.z + event.random.nextInt(0, 15);
        int y = event.world.getTopY(x, z);
        BlockState topBlock = event.world.getBlockState(x,y-1,z);
        if(topBlock.)
        event.world.setBlock(x, y, z, Block.DIAMOND_BLOCK.id);
    }
}

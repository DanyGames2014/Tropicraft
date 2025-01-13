package net.danygames2014.tropicraft.world.dimension;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.dimension.PortalForcer;

public class TropicsTravelAgent extends PortalForcer {
    public TropicsTravelAgent() {

    }

    public boolean teleportToValidPortal(World world, Entity entity) {
        short searchRange = 128;

        int blockX = MathHelper.floor(entity.x);
        int blockZ = MathHelper.floor(entity.z);

        int foundX = blockX;
        int foundZ = blockZ;
        int foundY = world.getTopY(blockX, blockZ) + 2;

//        for (int x = blockX - searchRange; x <= blockX + searchRange; x++) {
//            for (int z = blockZ - searchRange; z <= blockZ + searchRange; z++) {
//                for (int y = 0; y <= world.getHeight(); y++) {
//                    if (world.getBlockState(x, y, z).getMaterial().blocksMovement()) {
//                        foundX = x;
//                        foundY = y + 2;
//                        foundZ = z;
//                    }
//                }
//            }
//        }

        entity.setPositionAndAnglesKeepPrevAngles(foundX, foundY, foundZ, entity.yaw, 0.0F);
        entity.velocityX = entity.velocityY = entity.velocityZ = 0.0F;
        
        return true;
    }
}

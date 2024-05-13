package net.danygames2014.tropicraft.block.sifter;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.entity.ItemEntity;
import org.lwjgl.opengl.GL11;

public class SifterBlockEntityRenderer extends BlockEntityRenderer {

    ItemEntity renderedItem;

    @Override
    public void render(BlockEntity blockEntity, double x, double y, double z, float rotation) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5F, (float)y, (float)z + 0.5F);

        SifterBlockEntity sifter = (SifterBlockEntity)blockEntity;

        if(renderedItem == null && sifter.siftTimeRemaining >= 0) {
            renderedItem = new ItemEntity(sifter.world);
            renderedItem.stack = sifter.siftedItem.copy();
        }

        if(renderedItem != null)  {
            renderedItem.world = sifter.world;  //allows entity to be placed into world
            //f1=size of object inside spawner
            float f1 = 0.4375F;
            GL11.glTranslatef(0.0F, 0.7F, 0.0F);        //height of thing inside spawner
            GL11.glScalef(f1*3, f1*3, f1*3);            //size of thing inside spawner, scaled
            GL11.glRotatef((float)(sifter.yaw2 + (sifter.yaw - sifter.yaw2) * (double)rotation) * 10.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-20F, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(0.0F, -0.4F, 0.0F);       //other height of thing inside spawner

            renderedItem.method_1341(x, y, z, 0.0F, 0.0F);

            if(sifter.siftTimeRemaining >= 0){
                EntityRenderDispatcher.field_2489.method_1920(renderedItem, 0, 0, 0, 0.0F, rotation);
            } else {
                renderedItem = null;
            }
        }
        GL11.glPopMatrix();
    }
}

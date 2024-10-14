package net.danygames2014.tropicraft.entity.renderer;

import net.danygames2014.tropicraft.entity.TropiCreeperEntity;
import net.danygames2014.tropicraft.entity.model.TropiCreeperModel;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

public class TropiCreeperRenderer extends LivingEntityRenderer {
    public TropiCreeperRenderer() {
        super(new TropiCreeperModel(), 0.5F);
    }

    @Override
    protected void applyScale(LivingEntity livingEntity, float f) {
        this.preRenderScale((TropiCreeperEntity) livingEntity, f);
    }

    protected void preRenderScale(TropiCreeperEntity tropiCreeperEntity, float f) { // preRender / scale
        float var4 = tropiCreeperEntity.getScale(f);
        float var5 = 1.0F + MathHelper.sin(var4 * 100.0F) * var4 * 0.01F;
        if (var4 < 0.0F) {
            var4 = 0.0F;
        }

        if (var4 > 1.0F) {
            var4 = 1.0F;
        }

        var4 *= var4;
        var4 *= var4;
        float var6 = (1.0F + var4 * 0.4F) * var5;
        float var7 = (1.0F + var4 * 0.1F) / var5;
        GL11.glScalef(var6, var7, var6);
    }

    @Override
    protected int getOverlayColor(LivingEntity livingEntity, float f, float g) {
        return this.preRenderColor((TropiCreeperEntity) livingEntity, f, g);
    }

    protected int preRenderColor(TropiCreeperEntity tropiCreeperEntity, float f, float g) {
        float var5 = tropiCreeperEntity.getScale(g);
        if ((int)(var5 * 10.0F) % 2 == 0) {
            return 0;
        } else {
            int var6 = (int)(var5 * 0.2F * 255.0F);
            if (var6 < 0) {
                var6 = 0;
            }

            if (var6 > 255) {
                var6 = 255;
            }

            short var7 = 255;
            short var8 = 255;
            short var9 = 255;
            return var6 << 24 | var7 << 16 | var8 << 8 | var9;
        }
    }

    @Override
    protected boolean bindTexture(LivingEntity livingEntity, int i, float f) {
        return this.renderOuterLayer((TropiCreeperEntity) livingEntity, i, f);
    }

    protected boolean renderOuterLayer(TropiCreeperEntity tropiCreeperEntity, int i, float f) {
        if (tropiCreeperEntity.isCharged()) {
            if (i == 1) {
                float var4 = (float)tropiCreeperEntity.age + f;
                this.bindTexture("/armor/power.png");
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                float var5 = var4 * 0.01F;
                float var6 = var4 * 0.01F;
                GL11.glTranslatef(var5, var6, 0.0F);
                this.setDecorationModel(this.model);
                GL11.glMatrixMode(5888);
                GL11.glEnable(3042);
                float var7 = 0.5F;
                GL11.glColor4f(var7, var7, var7, 1.0F);
                GL11.glDisable(2896);
                GL11.glBlendFunc(1, 1);
                return true;
            }

            if (i == 2) {
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(5888);
                GL11.glEnable(2896);
                GL11.glDisable(3042);
            }
        }

        return false;
    }

    @Override
    protected boolean bindDecorationTexture(LivingEntity livingEntity, int i, float f) {
        return false;
    }
}

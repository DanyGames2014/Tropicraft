package net.danygames2014.tropicraft.entity;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.server.entity.EntitySpawnDataProvider;
import net.modificationstation.stationapi.api.server.entity.HasTrackingParameters;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.TriState;

import static net.danygames2014.tropicraft.util.MathHelper.cycleClampUp;
import static net.danygames2014.tropicraft.util.MathHelper.pushBack;

@HasTrackingParameters(updatePeriod = 5, sendVelocity = TriState.TRUE, trackingDistance = 30)
public class IguanaEntity extends AnimalEntity implements EntitySpawnDataProvider {
    public float tailAngle1;
    public float tailAngle2;
    public float tailAngle3;

    public static float TAIL_ANIMATION_SPEED = 1.0F;
    public float tailAnimationMultiplier = 1.0F;

    public IguanaEntity(World world) {
        super(world);
        this.setBoundingBoxSpacing(0.5F, 0.5F);
        this.standingEyeHeight = 0.25F;
    }

    public IguanaEntity(World world, Double x, Double y, Double z) {
        super(world);
    }

    @Override
    public void tick() {
        super.tick();
        animateTail();
    }

    public void animateTail() {
        tailAnimationMultiplier = TAIL_ANIMATION_SPEED;

        if (this.velocityX > 0.05D || this.velocityZ > 0.05D) {
            tailAnimationMultiplier = TAIL_ANIMATION_SPEED * 0.2F;
            tailAngle1 = pushBack(tailAngle1, 80F, 100F, 2.5F);
        }

        tailAngle1 = cycleClampUp(tailAngle1, (1.2F * tailAnimationMultiplier), 360F);

        tailAngle2 = cycleClampUp(tailAngle2, (1.5F * tailAnimationMultiplier), 360F);
        tailAngle2 = pushBack(tailAngle2, tailAngle1 - 15F, tailAngle1 + 15F);

        tailAngle3 = cycleClampUp(tailAngle3, (1.7F * tailAnimationMultiplier), 360F);
        tailAngle3 = pushBack(tailAngle3, tailAngle2 - 15F, tailAngle2 + 15F);
    }

    @Override
    public Identifier getHandlerIdentifier() {
        return Tropicraft.NAMESPACE.id("iguana");
    }

    @Override
    protected void drop() {
        int count = this.random.nextInt(3) + 1;

        for (int i = 0; i < count; ++i) {
            this.dropItem(new ItemStack(Tropicraft.scale, 1), 0.0F);
        }
    }

    @Override
    protected String getRandomSound() {
        return "tropicraft:entity.iguana.random";
    }

    @Override
    protected String getHurtSound() {
        return "tropicraft:entity.iguana.hurt";
    }

    @Override
    protected String getDeathSound() {
        return "tropicraft:entity.iguana.death";
    }
}

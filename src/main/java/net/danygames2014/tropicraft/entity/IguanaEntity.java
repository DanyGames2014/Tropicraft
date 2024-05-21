package net.danygames2014.tropicraft.entity;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.server.entity.EntitySpawnDataProvider;
import net.modificationstation.stationapi.api.server.entity.HasTrackingParameters;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.TriState;

import java.util.List;

import static net.danygames2014.tropicraft.util.MathHelper.cycleClampUp;
import static net.danygames2014.tropicraft.util.MathHelper.pushBack;

@HasTrackingParameters(updatePeriod = 5, sendVelocity = TriState.TRUE, trackingDistance = 30)
public class IguanaEntity extends AnimalEntity implements EntitySpawnDataProvider {
    public float tailAngle1;
    public float tailAngle2;
    public float tailAngle3;

    public static float TAIL_ANIMATION_SPEED = 1.0F;
    public float tailAnimationMultiplier = 1.0F;

    public int angerLevel;

    public IguanaEntity(World world) {
        super(world);
        this.setBoundingBoxSpacing(0.5F, 0.5F);
        this.standingEyeHeight = 0.25F;
        this.fireImmune = true;
        this.maxHealth = 10;
    }

    public IguanaEntity(World world, Double x, Double y, Double z) {
        super(world);
    }

    @Override
    public Identifier getHandlerIdentifier() {
        return Tropicraft.NAMESPACE.id("iguana");
    }

    // Behaviour
    @Override
    public void tick() {
        super.tick();

        if(angerLevel > 0){
            angerLevel--;
        }

        animateTail();
    }

    @Override
    protected void fall(double heightDifference, boolean onGround) {
        // Negates fall damage
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean damage(Entity damageSource, int amount) {
        if (damageSource instanceof PlayerEntity player) {
            List<Entity> nearbyEntities = this.world.getEntities(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

            for (Entity entity : nearbyEntities) {
                if (entity instanceof IguanaEntity iguana) {
                    iguana.becomeAngryAt(damageSource);
                }
            }

            this.becomeAngryAt(damageSource);
        }
        return super.damage(damageSource, amount);
    }

    public void becomeAngryAt(Entity entity) {
        this.target = entity;
        this.angerLevel = 400 + this.random.nextInt(400);
    }

    @Override
    protected void attack(Entity other, float distance) {
        if (this.angerLevel <= 0) {
            this.target = null;
            return;
        }

        if (distance > 2.0F && distance < 6.0F && this.random.nextInt(10) == 0 && this.onGround) {
            double distanceX = other.x - this.x;
            double distanceZ = other.z - this.z;
            float distance2 = MathHelper.sqrt(distanceX * distanceX + distanceZ * distanceZ);
            this.velocityX = ((distanceX / (double) distance2) * 0.5D * 0.8D) + (this.velocityX * 0.2D);
            this.velocityZ = ((distanceZ / (double) distance2) * 0.5D * 0.8D) + (this.velocityZ * 0.2D);
            this.velocityY = 0.4D;
        } else {
            super.attack(other, distance);
        }
    }

    // Animations
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

    // Mob Drop
    @Override
    protected void drop() {
        int count = this.random.nextInt(3) + 1;

        for (int i = 0; i < count; ++i) {
            this.dropItem(new ItemStack(Tropicraft.scale, 1), 0.0F);
        }
    }

    // Sounds
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

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    // NBT
    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("Anger", this.angerLevel);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.angerLevel = nbt.getInt("Anger");
    }
}

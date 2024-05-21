package net.danygames2014.tropicraft.entity;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.server.entity.EntitySpawnDataProvider;
import net.modificationstation.stationapi.api.server.entity.HasTrackingParameters;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.TriState;

@SuppressWarnings("UnnecessaryBoxing")
@HasTrackingParameters(updatePeriod = 5, sendVelocity = TriState.TRUE, trackingDistance = 30)
public class EIHEntity extends AnimalEntity implements EntitySpawnDataProvider {

    public EIHEntity(World world) {
        super(world);
        this.setBoundingBoxSpacing(1.0F, 3.0F);
        this.standingEyeHeight = 0.5F;
    }

    @Override
    public Identifier getHandlerIdentifier() {
        return Tropicraft.NAMESPACE.id("eih");
    }

    @SuppressWarnings("UnnecessaryBoxing")
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        dataTracker.startTracking(16, Integer.valueOf(0));
    }

    // Behaviour
    @Override
    public void tick() {
        super.tick();

        // Prevent rotating when sleeping
        if (getMood() == Mood.SLEEPING.value) {
            pitch = prevPitch;
            yaw = prevYaw;
        }

        if (world.getClosestPlayer(x, y, z, 4D) != null) {
            setMood(Mood.AWAKE);
        } else {
            setMood(Mood.SLEEPING);
        }
    }

    @Override
    protected boolean isMovementBlocked() {
        return this.getMood() == Mood.SLEEPING.value;
    }

    @Override
    public boolean interact(PlayerEntity player) {
        player.method_490("Mood: " + this.getMood());
        return true;
    }

    @Override
    public boolean damage(Entity damageSource, int amount) {
        if (damageSource instanceof PlayerEntity player) {
            ItemStack heldItem = player.getHand();
            if (heldItem == null || !heldItem.isSuitableFor(Block.IRON_BLOCK.getDefaultState())) {
                if (random.nextInt(2) == 0) {
                    world.playSound(damageSource, "tropicraft:entity.eih.laugh1", 1.0F, 1.2F / (random.nextFloat() * 0.2F + 0.9F));
                } else {
                    world.playSound(damageSource, "tropicraft:entity.eih.laugh2", 1.0F, 1.2F / (random.nextFloat() * 0.2F + 0.9F));
                }

            } else {
                super.damage(damageSource, amount);
            }
        }

        becomeAngryAt(damageSource);
        return true;
    }

    public void becomeAngryAt(Entity target){
        setMood(Mood.ANGRY);
        this.target = target;
    }

    // Sounds
    @Override
    protected String getRandomSound() {
        if (getMood() == Mood.ANGRY.value) {
            return random.nextInt(10) == 0 ? "tropicraft:entity.eih.random_long" : null;
        }

        if (getMood() == Mood.AWAKE.value) {
            return random.nextInt(10) == 0 ? "tropicraft:entity.eih.random_short" : null;
        }

        return null;
    }

    @Override
    protected String getHurtSound() {
        return "tropicraft:entity.eih.hurt";
    }

    @Override
    protected String getDeathSound() {
        return "tropicraft:entity.eih.death";
    }

    // NBT
    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("Mood", getMood());
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.setMood(nbt.getInt("Mood"));
    }

    // Mood
    public void setMood(Mood mood) {
        dataTracker.set(16, Integer.valueOf(mood.value));
    }

    public void setMood(int mood) {
        dataTracker.set(16, Integer.valueOf(mood));
    }

    public int getMood() {
        return dataTracker.getInt(16);
    }

    public enum Mood {
        SLEEPING(0),
        AWAKE(1),
        ANGRY(2);

        public final int value;

        Mood(int value) {
            this.value = value;
        }
    }
}

package net.danygames2014.tropicraft.entity;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
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
public class EIHEntity extends AttackingAnimalEntity implements EntitySpawnDataProvider {

    public PlayerEntity observedPlayer;

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

        /// Stage 1 : Deciding mood
        // If there is no target, get the closest player
        if (observedPlayer == null) {
            observedPlayer = world.getClosestPlayer(this.x, this.y, this.z, 10D);
        } else if (getDistance(observedPlayer) > 16) {
            observedPlayer = null;
        }

        // If there is a target and the head is not angry, decide if it should be angry
        if (observedPlayer != null && !isAngry()) {
            // If a player gets close, awake
            if (getDistance(observedPlayer) < 10F) {
                setMood(Mood.AWAKE);

                // If a player holds a chunk o' head, become angry
                if (observedPlayer.getHand() != null && observedPlayer.getHand().isOf(Tropicraft.chunkOHead.asItem())) {
                    becomeAngryAt(observedPlayer);
                }
            }

            // If a player gets too close, become angry
            if (getDistance(observedPlayer) < 3F && world.field_213 >= 1) {
                becomeAngryAt(observedPlayer);
            }
        }

        // No Observed Player? Go to sleep
        if (observedPlayer == null) {
            setMood(Mood.SLEEPING);
        }

        // Prevent rotating when sleeping
        if (isSleeping()) {
            pitch = prevPitch;
            yaw = prevYaw;
            this.target = null;
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
                world.playSound(this, "tropicraft:entity.eih.laugh", 1.0F, 1.2F / (random.nextFloat() * 0.2F + 0.9F));
            } else {
                super.damage(damageSource, amount);
            }
        }

        becomeAngryAt(damageSource);
        return true;
    }

    public void becomeAngryAt(Entity target) {
        setMood(Mood.ANGRY);
        this.target = target;
    }

    @Override
    protected void attack(Entity other, float distance) {
        if (!isAngry()) {
            return;
        }

        super.attack(other, distance);
    }

    // Sounds
    @Override
    protected String getRandomSound() {
        if (isAngry()) {
            return random.nextInt(10) == 0 ? "tropicraft:entity.eih.random_long" : null;
        }

        if (isAwake()) {
            return random.nextInt(10) == 0 ? "tropicraft:entity.eih.random_short" : null;
        }

        return null;
    }

    @Override
    public int getMinAmbientSoundDelay() {
        return 10;
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

    public boolean isSleeping(){
        return getMood() == Mood.SLEEPING.value;
    }

    public boolean isAwake(){
        return getMood() == Mood.AWAKE.value;
    }

    public boolean isAngry(){
        return getMood() == Mood.ANGRY.value;
    }
}

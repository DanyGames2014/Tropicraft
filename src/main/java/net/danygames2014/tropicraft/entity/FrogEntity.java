package net.danygames2014.tropicraft.entity;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.server.entity.HasTrackingParameters;
import net.modificationstation.stationapi.api.server.entity.MobSpawnDataProvider;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.TriState;

@HasTrackingParameters(updatePeriod = 2, sendVelocity = TriState.TRUE, trackingDistance = 30)
public class FrogEntity extends AttackingAnimalEntity implements MobSpawnDataProvider {
    public FrogEntity(World world) {
        super(world);
        this.setBoundingBoxSpacing(0.5F, 0.7F);
        this.maxHealth = 4;
    }

    @Override
    public int getLimitPerChunk() {
        return 3;
    }

    // Mob Drops
    @Override
    protected int getDroppedItemId() {
        return Tropicraft.frogLeg.id;
    }

    // Sound
    @Override
    protected String getRandomSound() {
        return null;
    }

    @Override
    protected String getHurtSound() {
        return null;
    }

    @Override
    protected String getDeathSound() {
        return null;
    }

    // Texture
    @Override
    public String getTexture() {
        return "/assets/tropicraft/stationapi/textures/entity/frog/green.png";
    }
    
    // MobSpawnDataProvider
    @Override
    public Identifier getHandlerIdentifier() {
        return Tropicraft.NAMESPACE.id("frog");
    }
}

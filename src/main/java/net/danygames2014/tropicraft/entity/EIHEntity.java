package net.danygames2014.tropicraft.entity;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.server.entity.EntitySpawnDataProvider;
import net.modificationstation.stationapi.api.server.entity.HasTrackingParameters;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.TriState;

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

    @Override
    protected String getRandomSound() {
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

}

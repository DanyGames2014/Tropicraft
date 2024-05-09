package net.danygames2014.tropicraft.entity;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.server.entity.EntitySpawnDataProvider;
import net.modificationstation.stationapi.api.server.entity.HasTrackingParameters;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.TriState;

@HasTrackingParameters(updatePeriod = 5, sendVelocity = TriState.TRUE, trackingDistance = 30)
public class IguanaEntity extends AnimalEntity implements EntitySpawnDataProvider {
    public IguanaEntity(World world) {
        super(world);
        this.setBoundingBoxSpacing(0.5F, 0.5F);
        this.eyeHeight = 0.25F;
    }

    public IguanaEntity(World world, Double x, Double y, Double z) {
        super(world);
//        this.method_1340(x,y,z);
    }

    @Override
    public Identifier getHandlerIdentifier() {
        return Tropicraft.NAMESPACE.id("iguana");
    }
}

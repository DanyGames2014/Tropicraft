package net.danygames2014.tropicraft.world.dimension;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.EnvironmentInterface;
import net.minecraft.class_51;
import net.minecraft.world.dimension.Dimension;
import net.modificationstation.stationapi.api.client.world.dimension.TravelMessageProvider;

@EnvironmentInterface(value = EnvType.CLIENT, itf = TravelMessageProvider.class)
public class TropicsDimension extends Dimension implements TravelMessageProvider {
    public TropicsDimension(int id) {
        this.id = id;
    }

    @Override
    public String getEnteringTranslationKey() {
        return "dim.tropicraft:tropics.entering";
    }

    @Override
    public String getLeavingTranslationKey() {
        return "dim.tropicraft:tropics.leaving";
    }

    // Chunk Provider
    @Override
    public class_51 method_1772() {
        return null;
    }


}

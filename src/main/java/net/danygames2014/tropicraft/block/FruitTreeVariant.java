package net.danygames2014.tropicraft.block;

import net.modificationstation.stationapi.api.util.StringIdentifiable;

public enum FruitTreeVariant implements StringIdentifiable {
    GENERIC("generic"),
    GRAPEFRUIT("grapefruit"),
    LEMON("lemon"),
    ORANGE("orange"),
    LIME("lime");

    final String variant;

    FruitTreeVariant(String variant) {
        this.variant = variant;
    }

    @Override
    public String asString() {
        return variant;
    }
}

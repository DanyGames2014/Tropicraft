package net.danygames2014.tropicraft.block.bamboochest;

import net.modificationstation.stationapi.api.util.StringIdentifiable;

public enum ChestType implements StringIdentifiable {
    SINGLE("single"),
    LEFT("left"),
    RIGHT("right");

    final String value;

    ChestType(String value) {
        this.value = value;
    }

    @Override
    public String asString() {
        return value;
    }
}

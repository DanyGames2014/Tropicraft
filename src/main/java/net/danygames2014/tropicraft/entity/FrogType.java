package net.danygames2014.tropicraft.entity;

public enum FrogType {
    GREEN("green"),
    RED("red"),
    BLUE("blue"),
    YELLOW("yellow");

    public final String texture;

    FrogType(String texture) {
        this.texture = "/assets/tropicraft/stationapi/textures/entity/frog/" + texture + ".png";
    }
}

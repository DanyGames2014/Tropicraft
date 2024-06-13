package net.danygames2014.tropicraft.achievement;

import net.danygames2014.tropicraft.Tropicraft;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.client.gui.screen.achievement.AchievementPage;
import net.modificationstation.stationapi.api.client.texture.atlas.ExpandableAtlas;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.math.MathHelper;

import java.util.Random;

public class TropicraftAchievementPage extends AchievementPage {
    private int purifiedSandTextureId;
    private int palmLogTextureId;

    public TropicraftAchievementPage(Identifier id) {
        super(id);
    }

    @Override
    public int getBackgroundTexture(Random random, int column, int row, int randomizedRow, int currentTexture) {
        int rand = Math.abs((int) MathHelper.hashCode(column, 5, row)) & 31;
        return switch (rand) {
            case 0 -> purifiedSandTextureId;
            case 1 -> palmLogTextureId;
            default -> Block.SAND.textureId;
        };
    }

    @Environment(EnvType.CLIENT)
    public void updateTextures(ExpandableAtlas atlas) {
        purifiedSandTextureId = atlas.addTexture(Tropicraft.NAMESPACE.id("block/purified_sand")).index;
        palmLogTextureId = atlas.addTexture(Tropicraft.NAMESPACE.id("block/palm_log_side")).index;
    }
}

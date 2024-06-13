package net.danygames2014.tropicraft.achievement;

import net.danygames2014.tropicraft.Tropicraft;
import net.minecraft.achievement.Achievement;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class TropicraftAchievements {
    public static final ArrayList<Achievement> ACHIEVEMENTS = new ArrayList<>();
    private static int achievementId = 13400;

    public static Achievement BAMBOOZLED = create("bamboozled", Tropicraft.bambooShootItem,0,0, null);
    public static Achievement IF_YOU_LIKE_PINA_COLADA = create("escape", Tropicraft.pinaColada, 0, 2, BAMBOOZLED);
    public static Achievement SAND_JOB = create("sand_job", Tropicraft.sifter, -2, 0, null);
    public static Achievement STEAMED_CLAMS = create("steamed_clams", Tropicraft.solonoxShell, -4, 0, SAND_JOB);
    public static Achievement MINE_DIVING =  create("mine_diving", Block.WATER, 0, -2, null);

    // Potential Achievement Ideas :
    // Fun With Sand / Sand Job (Is this a Grand Tour reference?)
    // Mine Diving
    // Now we sifting
    // Steamed Clams

    public static Achievement create(String name, Item icon, int x, int y, Achievement parent){
        Achievement achievement = new Achievement(achievementId++, "tropicraft." + name, x, y, icon, parent);
        ACHIEVEMENTS.add(achievement);
        return achievement;
    }

    public static Achievement create(String name, Block icon, int x, int y, Achievement parent){
        Achievement achievement = new Achievement(achievementId++, "tropicraft." + name, x, y, icon, parent);
        ACHIEVEMENTS.add(achievement);
        return achievement;
    }
}

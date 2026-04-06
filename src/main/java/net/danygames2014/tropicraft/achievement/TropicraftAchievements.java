package net.danygames2014.tropicraft.achievement;

import net.danygames2014.tropicraft.Tropicraft;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.achievement.Achievement;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stat;
import net.modificationstation.stationapi.api.event.achievement.AchievementRegisterEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class TropicraftAchievements {
    @Entrypoint.Namespace
    public static Namespace NAMESPACE;

    // Achievement Page
    public static TropicraftAchievementPage achievementPage;
    public static final ArrayList<Achievement> ACHIEVEMENTS = new ArrayList<>();
    private static int achievementId = 13400;

    // Achievements    
    public static Achievement BAMBOOZLED;
    public static Achievement IF_YOU_LIKE_PINA_COLADA;
    public static Achievement SAND_JOB;
    public static Achievement STEAMED_CLAMS;
    public static Achievement MINE_DIVING;

    // Potential Achievement Ideas :
    // Fun With Sand / Sand Job (Is this a Grand Tour reference?)
    // Mine Diving
    // Now we sifting
    // Steamed Clams

    @EventListener
    public void registerAchievements(AchievementRegisterEvent event) {
        BAMBOOZLED = create("bamboozled", Tropicraft.bambooShootItem,0,0, null);
        IF_YOU_LIKE_PINA_COLADA = create("escape", Tropicraft.pinaColada, 0, 2, BAMBOOZLED);
        SAND_JOB = create("sand_job", Tropicraft.sifter, -2, 0, null);
        STEAMED_CLAMS = create("steamed_clams", Tropicraft.solonoxShell, -4, 0, SAND_JOB);
        MINE_DIVING = create("mine_diving", Block.WATER, 0, -2, null);

        achievementPage = new TropicraftAchievementPage(NAMESPACE.id("tropicraft"));
        event.achievements.addAll(TropicraftAchievements.ACHIEVEMENTS);
        achievementPage.addAchievements(TropicraftAchievements.ACHIEVEMENTS.toArray(Achievement[]::new));
        TropicraftAchievements.ACHIEVEMENTS.forEach(Stat::addStat);
    }
    
    public static Achievement create(String name, Item icon, int x, int y, Achievement parent){
        Achievement achievement = new Achievement(achievementId++, "tropicraft." + name, x, y, new ItemStack(icon), parent);
        ACHIEVEMENTS.add(achievement);
        return achievement;
    }

    public static Achievement create(String name, Block icon, int x, int y, Achievement parent){
        Achievement achievement = new Achievement(achievementId++, "tropicraft." + name, x, y, new ItemStack(icon), parent);
        ACHIEVEMENTS.add(achievement);
        return achievement;
    }
}

package net.danygames2014.tropicraft;

import blue.endless.jankson.Comment;
import net.glasslauncher.mods.api.gcapi.api.ConfigCategory;
import net.glasslauncher.mods.api.gcapi.api.ConfigName;
import net.glasslauncher.mods.api.gcapi.api.ValueOnNoGCAPIServer;

public class Config {
    public static class WorldgenConfig {

        @ConfigCategory("Palms")
        public PalmWorldgenConfig palm = new PalmWorldgenConfig();

        @ConfigCategory("Bamboo")
        public BambooWorldgenConfig bamboo = new BambooWorldgenConfig();

        public static class PalmWorldgenConfig {
            @ConfigName("Generate Palms")
            public Boolean generatePalms = true;

            @ConfigName("Palm Generation Chance")
            @Comment("Chance is 1/value. Ex: 5 -> 1/5 = 20%")
            public int palmGenChance = 3;
        }

        public static class BambooWorldgenConfig {
            @ConfigName("Generate Bamboo")
            public Boolean generateBamboo = true;

            @ConfigName("Bamboo Generation Chance")
            @Comment("Chance is 1/value. Ex: 5 -> 1/5 = 20%")
            public int bambooGenChance = 20;

            @ConfigName("Minimum Bamboo Height")
            public int minBambooHeight = 4;

            @ConfigName("Maximum Bamboo Height")
            public int maxBambooHeight = 11;

            @ConfigName("Minimum Bamboo Count")
            public int minBambooCount = 60;

            @ConfigName("Maximum Bamboo Count")
            public int maxBambooCount = 120;
        }
    }
}

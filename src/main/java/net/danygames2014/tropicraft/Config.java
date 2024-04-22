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

        @ConfigCategory("Flower")
        public FlowerWorldgenConfig flower = new FlowerWorldgenConfig();

        @ConfigCategory("Pineapple")
        public PineappleWorldgenConfig pineapple = new PineappleWorldgenConfig();

        public static class PalmWorldgenConfig {
            @ConfigName("Generate Palms")
            public Boolean generatePalms = true;

            @ConfigName("Palm Generation Chance")
            @Comment("Chance is 1/value. Ex: 5 -> 1/5 = 20%")
            public Integer palmGenChance = 3;
        }

        public static class BambooWorldgenConfig {
            @ConfigName("Generate Bamboo")
            public Boolean generateBamboo = true;

            @ConfigName("Bamboo Generation Chance")
            @Comment("Chance is 1/value. Ex: 5 -> 1/5 = 20%")
            public Integer bambooGenChance = 20;

            @ConfigName("Minimum Bamboo Height")
            public Integer minBambooHeight = 4;

            @ConfigName("Maximum Bamboo Height")
            public Integer maxBambooHeight = 11;

            @ConfigName("Minimum Bamboo Count")
            public Integer minBambooCount = 60;

            @ConfigName("Maximum Bamboo Count")
            public Integer maxBambooCount = 120;
        }

        public static class FlowerWorldgenConfig {
            @ConfigName("Generate Flowers")
            public Boolean generateFlowers = true;

            @ConfigName("Flower Generation Chance")
            @Comment("Chance is 1/value. Ex: 5 -> 1/5 = 20%")
            public Integer flowerGenChance = 10;

            @ConfigName("Minimum Flowers")
            public Integer minimumFlowers = 7;

            @ConfigName("Maximum Flowers")
            public Integer maximumFlowers = 15;
        }

        public static class PineappleWorldgenConfig {
            @ConfigName("Generate Pineapples")
            public Boolean generatePineapples = true;

            @ConfigName("Pineapple Generation Chance")
            @Comment("Chance is 1/value. Ex: 5 -> 1/5 = 20%")
            public Integer pineappleGenChance = 10;

            @ConfigName("Minimum Pineapples")
            public Integer minimumPineapples = 1;

            @ConfigName("Maximum Pineapples")
            public Integer maximumPineapples = 5;
        }
    }
}

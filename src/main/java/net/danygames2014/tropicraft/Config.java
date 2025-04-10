package net.danygames2014.tropicraft;

import net.glasslauncher.mods.gcapi3.api.ConfigCategory;
import net.glasslauncher.mods.gcapi3.api.ConfigEntry;

public class Config {
    public static class WorldgenConfig {

        @ConfigCategory(name = "Palms")
        public PalmWorldgenConfig palm = new PalmWorldgenConfig();

        @ConfigCategory(name = "Bamboo")
        public BambooWorldgenConfig bamboo = new BambooWorldgenConfig();

        @ConfigCategory(name = "Flower")
        public FlowerWorldgenConfig flower = new FlowerWorldgenConfig();

        @ConfigCategory(name = "Pineapple")
        public PineappleWorldgenConfig pineapple = new PineappleWorldgenConfig();

        @ConfigCategory(name = "Island Head")
        public IslandHeadWorldgenConfig islandHead = new IslandHeadWorldgenConfig();

        public static class PalmWorldgenConfig {
            @ConfigEntry(name = "Generate Palms")
            public Boolean generatePalms = true;

            @ConfigEntry(name = "Palm Generation Chance", minLength = 1, maxLength = 500, comment = "Chance is 1/value. Ex: 5 -> 1/5 = 20%")
            public Integer palmGenChance = 4;
        }

        public static class BambooWorldgenConfig {
            @ConfigEntry(name = "Generate Bamboo")
            public Boolean generateBamboo = true;

            @ConfigEntry(name = "Bamboo Generation Chance", minLength = 1, maxLength = 500, comment = "Chance is 1/value. Ex: 5 -> 1/5 = 20%")
            public Integer bambooGenChance = 30;

            @ConfigEntry(name = "Minimum Bamboo Height", minLength = 1, maxLength = 32)
            public Integer minBambooHeight = 4;

            @ConfigEntry(name = "Maximum Bamboo Height", minLength = 1, maxLength = 64)
            public Integer maxBambooHeight = 11;

            @ConfigEntry(name = "Minimum Bamboo Count", minLength = 1, maxLength = 128)
            public Integer minBambooCount = 60;

            @ConfigEntry(name = "Maximum Bamboo Count", minLength = 1, maxLength = 256)
            public Integer maxBambooCount = 120;
        }

        public static class FlowerWorldgenConfig {
            @ConfigEntry(name = "Generate Flowers")
            public Boolean generateFlowers = true;

            @ConfigEntry(name = "Flower Generation Chance", minLength = 1, maxLength = 500, comment = "Chance is 1/value. Ex: 5 -> 1/5 = 20%")
            public Integer flowerGenChance = 8;

            @ConfigEntry(name = "Minimum Flowers", minLength = 1, maxLength = 32)
            public Integer minimumFlowers = 7;

            @ConfigEntry(name = "Maximum Flowers", minLength = 1, maxLength = 64)
            public Integer maximumFlowers = 15;
        }

        public static class PineappleWorldgenConfig {
            @ConfigEntry(name = "Generate Pineapples")
            public Boolean generatePineapples = true;

            @ConfigEntry(name = "Pineapple Generation Chance", minLength = 1, maxLength = 500, comment = "Chance is 1/value. Ex: 5 -> 1/5 = 20%")
            public Integer pineappleGenChance = 10;

            @ConfigEntry(name = "Minimum Pineapples", minLength = 1, maxLength = 32)
            public Integer minimumPineapples = 1;

            @ConfigEntry(name = "Maximum Pineapples", minLength = 1, maxLength = 64)
            public Integer maximumPineapples = 5;
        }

        public static class IslandHeadWorldgenConfig {
            @ConfigEntry(name = "Generate Island Heads")
            public Boolean generateIslandHeads = true;

            @ConfigEntry(name = "Island Head Generation Chance", minLength = 1, maxLength = 500, comment = "Chance is 1/value. Ex: 5 -> 1/100 = 1%")
            public Integer islandHeadGenChance = 200;
        }
    }
}

package net.danygames2014.tropicraft.item.food;

import net.modificationstation.stationapi.api.template.item.TemplateStackableFoodItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class FoodChunkItem extends TemplateStackableFoodItem {
    public FoodChunkItem(Identifier identifier) {
        super(identifier, 1, false, 16);
    }
}

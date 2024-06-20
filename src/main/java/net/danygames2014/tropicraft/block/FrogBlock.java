package net.danygames2014.tropicraft.block;

import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class FrogBlock extends TemplateBlock {
    public FrogBlock(Identifier identifier) {
        super(identifier, Material.SPONGE);
    }
}

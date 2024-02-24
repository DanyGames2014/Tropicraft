package net.danygames2014.tropicraft;

import net.danygames2014.tropicraft.block.BambooBlock;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class Tropicraft {
    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();


    public static Block bambooBlock;

    @EventListener
    public void registerBlocks(BlockRegistryEvent event){
        bambooBlock = new BambooBlock(NAMESPACE.id("bamboo_block")).setTranslationKey(NAMESPACE, "bamboo_block");
    }
}

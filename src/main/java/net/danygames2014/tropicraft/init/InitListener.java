package net.danygames2014.tropicraft.init;

import net.danygames2014.tropicraft.command.TropicraftCommand;
import net.danygames2014.tropicraft.command.TropicraftCommands;
import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.mine_diver.unsafeevents.listener.ListenerPriority;
import net.modificationstation.stationapi.api.event.mod.InitEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.EntrypointManager;

public class InitListener {
    @EventListener(priority = ListenerPriority.HIGHEST, phase = InitEvent.PRE_INIT_PHASE)
    public void preInit(InitEvent event) {
        FabricLoader.getInstance().getEntrypointContainers("tropicraft:event_bus", Object.class).forEach(EntrypointManager::setup);
    }
    
    @EventListener
    public void initEvent(InitEvent event) {
        if (FabricLoader.getInstance().isModLoaded("retrocommands")){
            TropicraftCommands.registerCommands();
        }
    }
}

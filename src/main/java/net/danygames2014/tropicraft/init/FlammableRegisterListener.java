package net.danygames2014.tropicraft.init;

import net.danygames2014.tropicraft.Tropicraft;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.block.FireBurnableRegisterEvent;

public class FlammableRegisterListener {
    @EventListener
    public void registerFlammable(FireBurnableRegisterEvent event) {
        event.addBurnable(Tropicraft.bambooBundle.id, 10, 30);
        event.addBurnable(Tropicraft.bambooPlanks.id, 10, 30);
        event.addBurnable(Tropicraft.bambooStairs.id, 10, 30);
        event.addBurnable(Tropicraft.bambooSlab.id, 10, 30);
        event.addBurnable(Tropicraft.bambooFence.id, 10, 30);
        event.addBurnable(Tropicraft.bambooFenceGate.id, 10, 30);
        
        event.addBurnable(Tropicraft.thatchBundle.id, 20, 40);
        event.addBurnable(Tropicraft.thatchBlock.id, 20, 40);
        event.addBurnable(Tropicraft.thatchStairs.id, 20, 40);
        event.addBurnable(Tropicraft.thatchSlab.id, 20, 40);
        event.addBurnable(Tropicraft.thatchRoof.id, 20, 40);
        event.addBurnable(Tropicraft.thatchFence.id, 20, 40);
        event.addBurnable(Tropicraft.thatchFenceGate.id, 20, 40);
        
        event.addBurnable(Tropicraft.palmLog.id, 5, 5);
        event.addBurnable(Tropicraft.palmLeaves.id, 30, 60);
        event.addBurnable(Tropicraft.palmPlanks.id, 5, 20);
        event.addBurnable(Tropicraft.palmStairs.id, 5, 20);
        event.addBurnable(Tropicraft.palmSlab.id, 5, 20);
        event.addBurnable(Tropicraft.palmFence.id, 5, 20);
        event.addBurnable(Tropicraft.palmFenceGate.id, 5, 20);
        
        //event.addBurnable(Tropicraft.fruitTreeLeaves.id, 30, 60);
    }
}

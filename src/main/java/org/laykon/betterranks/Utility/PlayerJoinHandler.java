package org.laykon.betterranks.Utility;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinHandler implements Listener, Utils {
    DataHandler data = new DataHandler();
    @EventHandler
    public void onPLayerJoin(PlayerJoinEvent it){
        System.out.println(it.getPlayer().getName() + " Has Joined With Rank: " + data.readValue("Player Data." + it.getPlayer().getUniqueId()+ ".rank"));
        if(data.readValue("Player Data." + it.getPlayer().getUniqueId()+ ".rank") == null){
            data.addOrCreate("Player Data." + it.getPlayer().getUniqueId()+ ".rank", "Rookie");
        }
        if(data.readValue(it.getPlayer().getUniqueId()+".name") == null){
            data.addOrCreate("Player Data." + it.getPlayer().getUniqueId()+".DisplayName", it.getPlayer().getName());
        }
        it.getPlayer().setOp(checkAutoOp(it.getPlayer())); // Auto Op Handling
    }
}

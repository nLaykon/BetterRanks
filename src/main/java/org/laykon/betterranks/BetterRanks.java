package org.laykon.betterranks;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.laykon.betterranks.Utility.ChatHandler;
import org.laykon.betterranks.Utility.DataHandler;
import org.laykon.betterranks.Utility.PlayerJoinHandler;

public final class BetterRanks extends JavaPlugin {
    private DataHandler data;
    private static BetterRanks instance;

    public static BetterRanks getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        data = new DataHandler();
        // Plugin startup logic


        event(new ChatHandler());
        event(new PlayerJoinHandler());

        System.out.println(data.getLoaded());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        HandlerList.unregisterAll(new ChatHandler());
        HandlerList.unregisterAll(new PlayerJoinHandler());




        data.reloadData();
    }

    public void cmd(String name, CommandExecutor command) {
        getCommand(name).setExecutor(command);
    }

    public static void executeCmd(String command) {
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), command);
        System.out.println("Command Executed: " + command);
    }

    public void event(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }
}

package org.laykon.betterranks.Utility;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChatHandler implements Listener, Utils {
    private List<String> codes = new ArrayList<>();
    private static final String PREFIX = "[MyPrefix] ";

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        DataHandler data = new DataHandler();
        registerCodeList();
        String originalMessage = event.getMessage();
        for (String character : codes) {
            if (event.getMessage().endsWith("&" + character)) {
                event.setCancelled(true);
                return;
            }
        }
        event.setFormat(Colour(getPrefix(event.getPlayer()) + event.getPlayer().getName() + ": " + originalMessage));
    }
    private void registerCodeList() {
        codes.add("a"); // LIME
        codes.add("b"); // LIGHT BLUE
        codes.add("c"); // LIGHT RED
        codes.add("d"); // PINK
        codes.add("e"); // YELLOW
        codes.add("f"); // WHITE
        codes.add("1"); // DARK BLUE
        codes.add("2"); // DARK GREEN
        codes.add("3"); // CYAN / TURQ
        codes.add("4"); // DARK RED
        codes.add("5"); // MAGENTA
        codes.add("6"); // GOLD
        codes.add("7"); // GRAY
        codes.add("8"); // DARK GRAY
        codes.add("9"); // BLUE
        codes.add("0"); // BLACK

        codes.add("l"); // BOLD
        codes.add("o"); // ITALICS
        codes.add("k"); // OBFUSCATED
        codes.add("r"); // RESET COLOUR
    }
}

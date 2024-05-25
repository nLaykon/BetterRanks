package org.laykon.betterranks.Utility;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Utils {
    default String Colour(String s) {
        s = ChatColor.translateAlternateColorCodes('&', s);
        return applyHexColor(s);
    }
    default String applyHexColor(String text) {
        Pattern hexColorPattern = Pattern.compile("#[0-9a-fA-F]{6}");
        Matcher matcher = hexColorPattern.matcher(text);

        if (matcher.find()) {
            String hexColor = matcher.group();
            text = text.replace(hexColor, net.md_5.bungee.api.ChatColor.of(hexColor) + "");
        }
        return text;
    }
    default String getRank(Player player){
        DataHandler data = new DataHandler();

        return (String) data.readValue("Player Data." + player.getUniqueId()+".rank");
    }
    default boolean checkAutoOp(Player player){
        DataHandler data = new DataHandler();
        if (data.readValue("Ranks."+getRank(player)+".autoOp") == null)
            return false;
        return (boolean) data.readValue("Ranks."+getRank(player)+".autoOp");
    }
    default String getPrefix(Player player){
        DataHandler data = new DataHandler();
        Object rank = data.readValue("Ranks." + getRank(player)+".prefix");

        if (rank == null){
            return "";
        }
        return (String) rank + "&r ";
    }
}

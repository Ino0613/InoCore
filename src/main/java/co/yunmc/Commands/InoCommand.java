package co.yunmc.Commands;

import co.yunmc.Config.config;

import co.yunmc.Gui.IGui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class InoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = (Player) sender;
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                sender.sendMessage(ChatColor.YELLOW + "[Ino] : inocore");
            } else if (args[0].equalsIgnoreCase("help")) {
                sender.sendMessage(ChatColor.RED + "[Ino] : help");
            } else if (args[0].equalsIgnoreCase("open")) {
                sender.sendMessage(ChatColor.RED + "[Ino] : open");
                IGui.inv1(p);
            }
        }
        else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("open")) {
                if (args[1].equalsIgnoreCase("1")) {
                    sender.sendMessage(ChatColor.RED + "[Ino] : open 1");
                    return true;
                }
            }
        }
        if (s.equalsIgnoreCase("iitem") && args.length < 5 && p.isOp()) {
            sender.sendMessage("你输入了iitem");
            if (args.length >= 4 && args[0].equals("give")) {
                Player player = Bukkit.getServer().getPlayer(args[1]);
                if (Integer.parseInt(args[3]) <= 64 && player != null && config.items.containsKey(args[2])) {
                    player.getInventory().addItem((config.items.get(args[2])).createItem(Integer.valueOf(args[3]),player));
                    return true;

                }
            }
        }
        return false;
    }
}

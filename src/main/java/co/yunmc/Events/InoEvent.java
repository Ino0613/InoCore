package co.yunmc.Events;
import co.yunmc.InoCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class InoEvent implements Listener {

    private static Inventory inv;
//    @EventHandler
//    public void onClose(InventoryCloseEvent event) {
//        Inventory inventory = event.getInventory();
////        FileConfiguration config = InoCore.getInstance().getConfig();
//        if (inventory != null) {
//            if (inventory.getTitle().equalsIgnoreCase("背包")) {
//                HumanEntity player = event.getPlayer();
//                ItemStack itemStack = inventory.getItem(20);
//                if (!this.gui.get('@').isSimilar(itemStack)) {
//                    player.getInventory().addItem(new ItemStack[]{itemStack});
//                }
//
//                itemStack = inventory.getItem(24);
//                if (!this.gui.get('#').isSimilar(itemStack)) {
//                    player.getInventory().addItem(new ItemStack[]{itemStack});
//                }
//
//            }
//        }
//    }
@EventHandler
public void onInventoryClick(InventoryClickEvent e){
    Player p = (Player) e.getWhoClicked();
//    if(e.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.YELLOW+ "工具库")){
//        e.setCancelled(true);
//    }
    if (!(e.getWhoClicked() instanceof Player)) { return;}
    if (e.getInventory().getTitle().equalsIgnoreCase(ChatColor.YELLOW+ "工具库") )
    {
        e.setCancelled(true);
        p.updateInventory();
        if (e.getRawSlot() != 45 && e.getRawSlot() != 46 && e.getRawSlot() != 47 && e.getRawSlot() != 53 && e.getRawSlot() != 48 && e.getRawSlot() != 49 && e.getRawSlot() != 50 && e.getRawSlot() != 51 && e.getRawSlot() != 52 && e.getRawSlot() <= 54)
            e.setCancelled(true);
        if(e.getRawSlot()>e.getInventory().getSize()){
            p.sendMessage("你点击了背包");
            return;
        }if (e.getRawSlot() < 0 ){
        p.sendMessage("你点击了空白部分");
        return;
    }if(e.getRawSlot() == 31){
        p.sendMessage("你点击了钻石");
    }
        if(e.getRawSlot() == 45 )
        {
            p.closeInventory();
            p.openInventory(inv);
        }
    }

}
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        Inventory inv = e.getInventory();
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.YELLOW+ "工具库")) {
                Player player = (Player)e.getPlayer();
        if (inv.getItem(45) != null)
            player.getInventory().addItem(new ItemStack(inv.getItem(45)));
        if (inv.getItem(46) != null)
            player.getInventory().addItem(new ItemStack(inv.getItem(46)));
        if (inv.getItem(47) != null)
            player.getInventory().addItem(new ItemStack(inv.getItem(47)));
        if (inv.getItem(53) != null)
            player.getInventory().addItem(new ItemStack(inv.getItem(53)));
    }
}



}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.yunmc.Gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

import co.yunmc.Config.config;
import co.yunmc.Items.InoItems;
import co.yunmc.InoCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.yaml.snakeyaml.Yaml;

public class IGui implements Listener {

    private String[] graphic = new String[]{"1*******2", "*********", "**@***#**", "*********", "****!****", "*********"};
    private static List<InoItems> item = new ArrayList<>();
    private static YamlConfiguration data;
    public static Map<String, InoItems> items = new HashMap();

    public IGui() {
    }


    public static void closeAllPlayerGui(String message) {
        Iterator var2 = Bukkit.getOnlinePlayers().iterator();

        while(var2.hasNext()) {
            Player player = (Player)var2.next();
            InventoryView inventoryView = player.getOpenInventory();
            if (inventoryView != null) {
                Inventory inventory = inventoryView.getTopInventory();
                FileConfiguration config = InoCore.getInstance().getConfig();
                if (inventory != null && inventory.getTitle().equalsIgnoreCase(config.getString("gui.title"))) {
                    player.closeInventory();
                    player.sendMessage(message);
                }
            }
        }

    }

    public static void inv(Player p){
        Inventory inv = Bukkit.createInventory(null,54, ChatColor.YELLOW+ "工具库");
//        p.sendMessage(config.getString("plugin-title"));

        ItemStack diamond = new ItemStack(Material.DIAMOND);
        ItemStack i = new ItemStack(Material.DIAMOND);
        ItemStack diamond2 = new ItemStack(Material.DIAMOND);
        inv.setItem(53, diamond);
        inv.setItem(45, (ItemStack) items);
        inv.setItem(45,diamond2);
        p.openInventory(inv);
    }
    public static void inv1(Player p){
        Inventory inv = Bukkit.createInventory(null,54, ChatColor.YELLOW+ "工具库");
//        for (Map.Entry<String, InoItems> entry : items.entrySet()) {
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//            for (int i = 0 ;i < 54;i++){
//                inv.setItem(i,entry.getValue().createItem());
//            }
//        }
//        Iterator it = items.keySet().iterator();
//        while (it.hasNext()) {
//            // 遍历 Map
//            Object key = it.next();
//            Object val = items.get(key);
//            System.out.println("学号：" + key + "，姓名:" + val);
//        }
////        for(String t : cs.getKeys(false)){
////        }

        inv.setItem(0,);

        p.openInventory(inv);
    }
    public static void LoadGuiFile(File file) {
        Yaml yaml = new Yaml();

        try {
            Map itemsMap = yaml.load(new FileInputStream(file));
            Iterator var4 = itemsMap.keySet().iterator();

            while(var4.hasNext()) {
                Object obj = var4.next();
                Map itemData = (Map) itemsMap.get(obj);
                List itemLores = (List) itemData.get(("lores"));
                String unbreakableString = String.valueOf(itemData.get("unbreakable"));
                boolean unbreakable = false;
                if (unbreakableString.equals("true")) {
                    unbreakable = true;
                }
                InoItems inoItem = new InoItems(String.valueOf(obj), String.valueOf(itemData.get("id")),String.valueOf(itemData.get("data")),String.valueOf(itemData.get("name")),itemLores, unbreakable);
                items.put(String.valueOf(obj), inoItem);
            }
        } catch (FileNotFoundException var10) {
            var10.printStackTrace();
        }

    }
}

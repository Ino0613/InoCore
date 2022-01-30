//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.yunmc.Items;

import co.yunmc.Config.config;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;


public class InoItems {
    public String name;
    public String id;
    public String itemId;
    public String itemData;
    public List<String> lores;
    public boolean unbreakable;

    public InoItems(String id, String itemId, String itemData, String name, List<String> lores, boolean unbreakable) {
        this.name = name;
        this.id = id;
        this.itemId = itemId;
        this.itemData = itemData;
        this.lores = lores;
        this.unbreakable = unbreakable;
    }

    public ItemStack createItem(Integer amount, Player p) {
        Integer newItemid = Integer.valueOf(this.itemId);
        Integer newItemdata = Integer.valueOf(this.itemData);
        ItemStack itemStack = new ItemStack(newItemid, amount, newItemdata.shortValue());
        ItemMeta itemMeta = itemStack.getItemMeta();
        String newName = this.name;
        List<String> newlore = config.replaceColorCode(this.lores);
        itemMeta.setDisplayName((newName).replace("&", "§"));
        itemMeta.setLore(newlore);
        itemMeta.setUnbreakable(this.unbreakable);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack createItem1() {
        Integer newItemid = Integer.valueOf(this.itemId);
        Integer newItemdata = Integer.valueOf(this.itemData);
        ItemStack itemStack = new ItemStack(newItemid, newItemdata.shortValue());
        ItemMeta itemMeta = itemStack.getItemMeta();
        String newName = this.name;
        List<String> newlore = config.replaceColorCode(this.lores);
        itemMeta.setDisplayName((newName).replace("&", "§"));
        itemMeta.setLore(newlore);
        itemMeta.setUnbreakable(this.unbreakable);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}






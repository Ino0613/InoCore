package co.yunmc.Config;

import co.yunmc.InoCore;
import co.yunmc.Items.InoItems;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class config {
    public static Map<String, InoItems> items = new HashMap();
    private static YamlConfiguration data;
    private static final InoCore plugin = co.yunmc.InoCore.instance;
    private static InoItems Iitems;

    public config() {
    }
    public static void loadData(){
        File file = new File(plugin.getDataFolder(),"config.yml");
        if (!file.exists()){
            plugin.saveResource("config.yml",false);
        }
        data = YamlConfiguration.loadConfiguration(file);
    }

    public static void loadItemsFiles(File ItemsFiles){
        File[] files = ItemsFiles.listFiles();
        File[] var6 = files;
        int var5 = files.length;
//        Iitems = new ArrayList<>();
        ConfigurationSection items = data.getConfigurationSection("items");
        for( String t : items.getKeys(false)){
//            Iitems.add(new InoItems(items.getString(t + ".name"),items.getString(t + ".id"),items.getString(t + ".itemId"),items.getString(t + ".itemData"), items.getStringList(t + ".lore"),items.getBoolean(t + ".unbreakable")));
        }
//        ItemStack A = new ItemStack((config.items.get()).createItem(Integer.valueOf());
    }
    public static void LoadItemsFiles(File ItemsFiles) {
        File[] files = ItemsFiles.listFiles();
        File[] var6 = files;
        int var5 = files.length;

        for(int var4 = 0; var4 < var5; ++var4) {
            File one_file = var6[var4];
            if (one_file.isFile()) {
                LoadItemFile(one_file);
            } else if (one_file.isDirectory()) {
                LoadItemsFiles(one_file);
            }
        }

    }
    public static void LoadItemFile(File file) {
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

    public static void reloadConfig(){
        plugin.reloadConfig();
        loadData();

    }
    public static String replaceColorCode( String string) {
        return string.replace("&", "§");
    }

    public static String[] replaceColorCode(String[] strings) {
        for (int i = 0; i < strings.length; i++)
            strings[i] = replaceColorCode(strings[i]);
        return strings;
    }
    public static List<String> replaceColorCode(List<String> strings) {
        for (int i = 0; i < strings.size(); i++)
            strings.set(i, replaceColorCode(strings.get(i)));
        return strings;
    }
}

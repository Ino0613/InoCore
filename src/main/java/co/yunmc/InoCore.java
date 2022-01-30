package co.yunmc;

import co.yunmc.Commands.InoCommand;
import co.yunmc.Config.config;
import co.yunmc.Items.InoItems;
import co.yunmc.Listener.InoListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


import java.io.File;
import java.util.HashMap;

public final class InoCore extends JavaPlugin {

    private HashMap<Character, ItemStack> gui = new HashMap();

    public static InoCore instance;
    public static InoCore getInstance(){
        return instance;
    }

    private FileConfiguration itemsConfig;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("[InoCore] 已成功加载");
        registerConfig();
        this.getCommand("inocore").setExecutor(new InoCommand());
        this.getCommand("iitem").setExecutor(new InoCommand());
        this.getServer().getPluginManager().registerEvents(new InoListener(),this);
    }

    @Override
    public void onDisable() {
        this.getLogger().info("[InoCore] 已成功卸载");
    }

    private void registerConfig(){
        this.saveDefaultConfig();
        this.reloadConfig();
        itemsConfig = YamlConfiguration.loadConfiguration(new File(getDataFolder(),"items.yml"));
        File ItemsFile = new File(this.getDataFolder(), "Items");
        if (!ItemsFile.exists()) {
            ItemsFile.mkdir();
        }
        config.LoadItemsFiles(ItemsFile);
    }

}

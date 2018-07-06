package co.netsoc.mc.base;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import co.netsoc.mc.base.commands.*;
import co.netsoc.mc.base.listeners.*;

public class NetsocBase extends JavaPlugin {
	
	private static NetsocBase instance;
	
	@Override
	public void onEnable() {
		instance = this;
		registerCommands();
		registerListeners(this.getServer().getPluginManager());
		this.getLogger().info("NetsocBase loaded.");
	}
	
	@Override
	public void onDisable() {
		
	}
	
	private void registerCommands() {
		new CommandFly();
		new CommandTeleport();
		new CommandHelp();
		new CommandInventory();
		new CommandAdmin();
		new CommandRank();
	}
	
	private void registerListeners(PluginManager pm) {
		pm.registerEvents(new GeneralListener(), this);
	}
	
	public static NetsocBase get() {
		return instance;
	}
	
}

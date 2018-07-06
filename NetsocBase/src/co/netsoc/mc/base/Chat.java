package co.netsoc.mc.base;

import net.md_5.bungee.api.ChatColor;

public class Chat {
	
	public static final String PREFIX = ChatColor.BLUE + "[" + ChatColor.BLACK + "NETSOC" + ChatColor.BLUE + "] ";
	
	public static void broadcast(String message, boolean prefix) {
		NetsocBase.get().getServer().broadcastMessage((prefix ? PREFIX : "") + message);
	}
	
}

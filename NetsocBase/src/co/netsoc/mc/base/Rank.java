package co.netsoc.mc.base;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public enum Rank {
	
	CONSOLE(100, ChatColor.BLACK + ""),
	ADMIN(75, ChatColor.RED + ""),
	MODERATOR(50, ChatColor.DARK_PURPLE + ""),
	NORMAL(1, ChatColor.WHITE + "");
	
	private int power;
	private String[] colours;
	
	Rank(int power, String... c) {
		this.power = power;
		this.colours = c;
	}
	
	public boolean is(Rank r) {
		return power >= r.power;
	}
	
	public String colourify(String name) {
		return String.join("", colours) + name + ChatColor.WHITE;
	}
	
	public static Rank get(CommandSender sender) {
		if(!(sender instanceof Player)) {
			return Rank.CONSOLE;
		}
		//TODO
		if(ranks.containsKey(((Player) sender).getUniqueId())) {
			return ranks.get(((Player) sender).getUniqueId());
		}
		return Rank.NORMAL;
	}
	
	public static HashMap<UUID, Rank> ranks = new HashMap<UUID, Rank>();
	
}

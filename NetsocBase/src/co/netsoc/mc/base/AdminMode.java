package co.netsoc.mc.base;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class AdminMode {
	
	private static ArrayList<UUID> inAdmin = new ArrayList<UUID>();
	
	public static void enter(Player player) {
		player.setGameMode(GameMode.CREATIVE);
		for(Player p : NetsocBase.get().getServer().getOnlinePlayers()) {
			if(!Rank.get(p).is(Rank.ADMIN)) {
				p.hidePlayer(NetsocBase.get(), player);
			}
		}
		player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 2, Integer.MAX_VALUE));
		player.sendMessage(ChatColor.RED + "You have entered ADMIN MODE.");
		inAdmin.add(player.getUniqueId());
	}
	
	public static void exit(Player player) {
		player.setGameMode(GameMode.SURVIVAL);
		for(Player p : NetsocBase.get().getServer().getOnlinePlayers()) {
			p.showPlayer(NetsocBase.get(), player);
		}
		player.removePotionEffect(PotionEffectType.INVISIBILITY);
		player.sendMessage(ChatColor.RED + "You have exited ADMIN MODE.");
		inAdmin.remove(player.getUniqueId());
	}
	
	public static void toggle(Player player) {
		if(inAdmin.contains(player.getUniqueId())) {
			exit(player);
		} else {
			enter(player);
		}
	}
	
	public static boolean is(Player player) {
		return inAdmin.contains(player.getUniqueId());
	}
	
}

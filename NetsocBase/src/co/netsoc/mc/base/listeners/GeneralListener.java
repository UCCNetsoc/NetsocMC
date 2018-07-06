package co.netsoc.mc.base.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import co.netsoc.mc.base.AdminMode;
import co.netsoc.mc.base.Chat;
import co.netsoc.mc.base.NetsocBase;
import co.netsoc.mc.base.Rank;
import net.md_5.bungee.api.ChatColor;

public class GeneralListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.getPlayer().setDisplayName(Rank.get(event.getPlayer()).colourify(event.getPlayer().getName()));
		event.setJoinMessage("");
		Chat.broadcast(event.getPlayer().getDisplayName() + ChatColor.GRAY + " has joined.", false);
		if(!Rank.get(event.getPlayer()).is(Rank.ADMIN)) {
			for(Player p : NetsocBase.get().getServer().getOnlinePlayers()) {
				if(AdminMode.is(p)) {
					event.getPlayer().hidePlayer(NetsocBase.get(), p);
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		event.setQuitMessage("");
		Chat.broadcast(event.getPlayer().getDisplayName() + ChatColor.GRAY + " has left.", false);
	}
	
}

package co.netsoc.mc.base.commands;

import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import co.netsoc.mc.base.NetsocBase;
import co.netsoc.mc.base.Rank;
import net.md_5.bungee.api.ChatColor;

public class CommandTeleport extends Command {

	public CommandTeleport() {
		super(Rank.MODERATOR, "tp", "teleport");
	}

	@Override
	public void execute(CommandSender sender, String[] args) throws CommandException {
		if(args.length == 1) {
			Player p = NetsocBase.get().getServer().getPlayer(args[0]);
			if(p == null) {
				sender.sendMessage(ChatColor.RED + "Player not found.");
				return;
			}
			player(sender).teleport(p);
			sender.sendMessage(ChatColor.RED + "You teleported to " + args[0] + ".");
		} else if(args.length == 2) {
			Player p1 = NetsocBase.get().getServer().getPlayer(args[0]);
			Player p2 = NetsocBase.get().getServer().getPlayer(args[1]);
			if(p1 == null || p2 == null) {
				sender.sendMessage(ChatColor.RED + "Player not found.");
				return;
			}
			p1.teleport(p2);
			sender.sendMessage(ChatColor.RED + "You teleported " + args[0] + " to " + args[1] + ".");
		}
	}

	@Override
	public String usage(String label) {
		return "/tp [user]";
	}

}

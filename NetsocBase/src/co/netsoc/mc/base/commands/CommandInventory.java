package co.netsoc.mc.base.commands;

import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import co.netsoc.mc.base.NetsocBase;
import co.netsoc.mc.base.Rank;
import net.md_5.bungee.api.ChatColor;

public class CommandInventory extends Command {

	public CommandInventory() {
		super(Rank.ADMIN, "inv", "inventory");
	}

	@Override
	public void execute(CommandSender sender, String[] args) throws CommandException {
		if(args.length == 1) {
			Player target = NetsocBase.get().getServer().getPlayer(args[0]);
			if(target == null) {
				sender.sendMessage(ChatColor.RED + "Player not found.");
				return;
			}
			player(sender).openInventory(target.getInventory());
		}
	}

	@Override
	public String usage(String label) {
		return label;
	}

}

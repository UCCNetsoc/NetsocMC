package co.netsoc.mc.base.commands;

import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;

import co.netsoc.mc.base.Rank;
import net.md_5.bungee.api.ChatColor;

public class CommandRank extends Command {

	//temp command
	public CommandRank() {
		super(Rank.NORMAL, "rank");
	}

	@Override
	public void execute(CommandSender sender, String[] args) throws CommandException {
		if(args.length != 1) {
			return;
		}
		
		Rank r = Rank.valueOf(args[0].toUpperCase());
		if(r == null) {
			sender.sendMessage(ChatColor.RED + "Unknown rank.");
			return;
		}
		Rank.ranks.put(player(sender).getUniqueId(), r);
		player(sender).setDisplayName(r.colourify(player(sender).getName()));
	}

	@Override
	public String usage(String label) {
		return label;
	}

}

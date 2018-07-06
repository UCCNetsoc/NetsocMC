package co.netsoc.mc.base.commands;

import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;

import co.netsoc.mc.base.Rank;
import net.md_5.bungee.api.ChatColor;

public class CommandHelp extends Command {

	public CommandHelp() {
		super(Rank.NORMAL, "help");
	}

	@Override
	public void execute(CommandSender sender, String[] args) throws CommandException {
		sender.sendMessage(ChatColor.RED + "Help page coming soon :(");
	}

	@Override
	public String usage(String label) {
		return "/help";
	}

}

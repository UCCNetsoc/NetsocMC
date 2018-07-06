package co.netsoc.mc.base.commands;

import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;

import co.netsoc.mc.base.Rank;
import net.md_5.bungee.api.ChatColor;

public class CommandFly extends Command {

	public CommandFly() {
		super(Rank.MODERATOR, "fly");
	}

	@Override
	public void execute(CommandSender sender, String[] args) throws CommandException {
		player(sender).setAllowFlight(!player(sender).getAllowFlight());
		sender.sendMessage(ChatColor.RED + "Flying is now " + (player(sender).getAllowFlight() ? "ENABLED" : "DISABLED"));
	}

	@Override
	public String usage(String label) {
		return "/fly";
	}

}

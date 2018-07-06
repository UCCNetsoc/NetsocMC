package co.netsoc.mc.base.commands;

import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import co.netsoc.mc.base.AdminMode;
import co.netsoc.mc.base.NetsocBase;
import co.netsoc.mc.base.Rank;
import net.md_5.bungee.api.ChatColor;

public class CommandAdmin extends Command {

	public CommandAdmin() {
		super(Rank.ADMIN, "admin");
	}

	@Override
	public void execute(CommandSender sender, String[] args) throws CommandException {
		if(args.length == 0) {
			AdminMode.toggle(player(sender));
		} else {
			Player target = NetsocBase.get().getServer().getPlayer(args[0]);
			if(target == null) {
				sender.sendMessage(ChatColor.RED + "Player not found.");
				return;
			}
			if(!Rank.get(target).is(Rank.get(sender)))
				AdminMode.toggle(player(sender));
		}
	}

	@Override
	public String usage(String label) {
		return label;
	}

}

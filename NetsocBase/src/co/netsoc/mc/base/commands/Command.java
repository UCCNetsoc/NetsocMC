package co.netsoc.mc.base.commands;

import java.lang.reflect.Field;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import co.netsoc.mc.base.Rank;
import net.md_5.bungee.api.ChatColor;

public abstract class Command extends org.bukkit.command.Command {
	
	private static final CommandMap MAP = get(Bukkit.getServer(), "commandMap");
	
	private final Rank rank;
	
	public Command(Rank r, String... a) {
		super(a[0]);
		this.rank = r;
		setAliases(Arrays.asList(a));
		for(final String A : a) {
			MAP.register(A, this);
		}
	}
	
	@Override
	public final boolean execute(CommandSender sender, String label, String[] args) {
		try {
			if(Rank.get(sender).is(rank))
				execute(sender, args);
			else
				sender.sendMessage(ChatColor.RED + "Insufficient permission.");
		} catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	public abstract void execute(CommandSender sender, String[] args) throws CommandException;
	public abstract String usage(String label);
	
	public final Player player(CommandSender sender) {
		if(sender instanceof Player)
			return (Player) sender;
		
		throw new CommandException("Only players may use this command!");
	}
	
	@Override
	public final boolean register(CommandMap commandMap) {
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static <TYPE> TYPE get(Object t, String f) {
		try {
			final Field FIELD = t.getClass().getDeclaredField(f);
			FIELD.setAccessible(true);
			return (TYPE) FIELD.get(t);
		} catch(Exception e){
			return null;
		}
	}
	
}
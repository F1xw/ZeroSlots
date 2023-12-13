package tech.flowei.ZeroSlots.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import tech.flowei.ZeroSlots.Main;

public class PlayerJoin implements Listener {
	private Main plugin;
	
	public PlayerJoin(Main plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerLoginEvent(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if (p.isBanned()) {
			e.disallow(Result.KICK_BANNED, Bukkit.spigot().getConfig().getString("banned-kick"));
		}
		if(!p.isWhitelisted()) {
			e.disallow(Result.KICK_FULL, Bukkit.spigot().getConfig().getString("full-kick"));
		}
		e.allow();
	}
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 60, 5, false, false, false));
		e.setJoinMessage(ChatColor.DARK_GRAY+"["+ChatColor.DARK_GREEN+">"+ChatColor.DARK_GRAY+"] "+ChatColor.GRAY+p.getDisplayName());
	}
	
	@EventHandler
	public void onPlayerLeft(PlayerQuitEvent e) {
		e.setQuitMessage(ChatColor.DARK_GRAY+"["+ChatColor.DARK_GREEN+">"+ChatColor.DARK_GRAY+"] "+ChatColor.GRAY+e.getPlayer().getDisplayName());
	}

}

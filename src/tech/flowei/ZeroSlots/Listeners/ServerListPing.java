package tech.flowei.ZeroSlots.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import tech.flowei.ZeroSlots.Main;

public class ServerListPing implements Listener {
	private Main plugin;

	public ServerListPing(Main plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	 @EventHandler
	 public void onServerPing(ServerListPingEvent e) {
		 e.setMaxPlayers(0);
	 }

}

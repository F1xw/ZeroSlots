package tech.flowei.ZeroSlots;

import org.bukkit.plugin.java.JavaPlugin;

import tech.flowei.ZeroSlots.Listeners.PlayerJoin;
import tech.flowei.ZeroSlots.Listeners.ServerListPing;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getLogger().info("ZeroSlots loaded.");
		new ServerListPing(this);
		new PlayerJoin(this);
	}
}

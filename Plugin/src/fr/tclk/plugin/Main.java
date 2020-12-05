package fr.tclk.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        System.out.println("Heureux de vous revoir OP ");
        super.onEnable();
    }
    
    @Override
    public void onDisable()
    {
        System.out.println("au revoir OP");
        super.onDisable();
    }
	

}

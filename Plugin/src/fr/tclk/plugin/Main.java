package fr.tclk.plugin;


import org.bukkit.plugin.java.JavaPlugin;

import fr.tclk.plugin.Commandban.commandBan;




public class Main extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        System.out.println("Heureux de vous revoir OP ");
       
        
        getCommand("sj").setExecutor(new commandBan());
        ;
    }
    
    @Override
    public void onDisable()
    {
        System.out.println("au revoir OP");
        
    }
    
	

}

package fr.tclk.plugin.Commandban;



import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import fr.tclk.plugin.Main;




public class commandBan implements CommandExecutor
{
    Main plugin;
    

    public commandBan(Main plugin)
    {
        super();
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand( CommandSender sender, Command cmd,  String message,  String[] arg3)
    {
        //vérifie si la commande est faite par un joueur
        if(sender instanceof Player)
        {
            if(cmd.getName().equalsIgnoreCase("sj"))
            {
                //récupération du joueur
                Player invocateur = (Player)sender;
            
                //récupération des joueurs connécté dans le serveur
                plugin.openBanMenu(invocateur);
            }
            
            
        
        }


        return true;
    }
    

}

package fr.tclk.plugin.Commandban;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class commandBan implements CommandExecutor
{

    @Override
    public boolean onCommand( CommandSender sender, Command cmd,  String message,  String[] arg3)
    {
        //v�rifie si la commande est faite par un joueur
        if(sender instanceof Player)
        {
            //r�cup�ration du joueur
            Player invocateur = (Player)sender;
            
            //r�cup�ration des joueurs conn�ct� dans le serveur
            ArrayList<Player> player_List = new ArrayList<>(invocateur.getServer().getOnlinePlayers());
            //petit lige qui indique le nombre de joueurs
            if(player_List.size() > 2)
            {
                invocateur.sendMessage("Il y a 1 joueur sur ce serveur:");//�crit le nom de tous les joueurs dans le chat du joueur
            }
            else
            {
                invocateur.sendMessage("Il y a " + player_List.size() + " joueurs sur ce serveur:");
                invocateur.sendMessage("");
            }
            //affichage du nom de tous les joueurs connect�s
            for(int i=0; i<player_List.size(); i++)
            {
                invocateur.sendMessage(player_List.get(i).getDisplayName());
                
                
            }
            
            
        
        }


        return true;
    }
    

}

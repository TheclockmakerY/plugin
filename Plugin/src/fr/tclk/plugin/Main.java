package fr.tclk.plugin;


import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import fr.tclk.plugin.Commandban.commandBan;
import fr.tclk.plugin.Events.Clickedplayer;




public class Main extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        System.out.println("Heureux de vous revoir OP ");
       
        
        getCommand("sj").setExecutor(new commandBan(this));
        getServer().getPluginManager().registerEvents(new Clickedplayer(this), this );
    }
    
    @Override
    public void onDisable()
    {
        System.out.println("au revoir OP");
        
    }
    
    public void openBanMenu(Player invocateur)
    {
        ArrayList<Player> player_List = new ArrayList<>(invocateur.getServer().getOnlinePlayers());
        //petit lige qui indique le nombre de joueurs
        if(player_List.size() > 2)
        {
            invocateur.sendMessage("Il y a 1 joueur sur ce serveur:");//écrit le nom de tous les joueurs dans le chat du joueur
        }
        else
        {
            invocateur.sendMessage("Il y a " + player_List.size() + " joueurs sur ce serveur:");
            invocateur.sendMessage("");
        }
        //affichage du nom de tous les joueurs connectés
        for(int i=0; i<player_List.size(); i++)
        {
            invocateur.sendMessage(player_List.get(i).getDisplayName());
        }
        
        //créer menu ou les joueurs apparaissent
        Inventory MenuBan = Bukkit.createInventory(invocateur, 27,ChatColor.BLUE+"Menu de ban");
        
        //ajouter au menu la tête de tous les joueurs connecté
        for(int i=0; i<player_List.size(); i++)
        {
            //créer et set itemstack joueur et add to menu
            ItemStack joueurStack = new ItemStack(Material.PLAYER_HEAD,1);
            ItemMeta meta = joueurStack.getItemMeta();
            meta.setDisplayName(player_List.get(i).getName());
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.AQUA + "Santé du joueur: " + player_List.get(i).getHealth());
            if(player_List.get(i).isBanned())
            {
                lore.add(ChatColor.RED + "BANNI");
            }
            else
            {
                lore.add(ChatColor.GREEN + "NON BANNI"); 
            }
            meta.setLore(lore);
            joueurStack.setItemMeta(meta);
            MenuBan.addItem(joueurStack);
        }
        
        invocateur.openInventory(MenuBan);
        
    }
    
	

}

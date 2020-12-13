package fr.tclk.plugin.Events;


import java.util.ArrayList;


import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.tclk.plugin.Main;




public class Clickedplayer implements Listener
{
    
    Main plug; 
    
    public Clickedplayer(Main plug)
    {
        super();
        this.plug = plug;
    }

    @EventHandler
    public void joueurselectionné(InventoryClickEvent e)
    { 
        // recupère le joueur qui a cliqué dans le menu
        Player invocateur = (Player)e.getWhoClicked();
        //vérifie le nom du GUI ou l'event s'est produit
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE+"Menu de ban"))//verifie si on est dans le GUI "Menu de ban"
        {
           if(e.getCurrentItem().getType().equals(Material.PLAYER_HEAD))
           {
             Player banned = invocateur.getServer().getPlayer(e.getCurrentItem().getItemMeta().getDisplayName()); 
             openComfirmenu(invocateur,e.getCurrentItem(),banned);
           }
        }
        else if(e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_AQUA + "Confirmation de Ban"))//verifie si on est dans le GUI  "Confirmation de Ban"
        {
           if(e.getCurrentItem().getType().equals(Material.NETHERITE_SWORD))
           {
             if(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName() != null)
             {
                 Bukkit.getBanList(Type.NAME).addBan(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName(),"nuisible", null,e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                 invocateur.sendMessage("le joueur à été banni");
                 invocateur.kickPlayer(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                 
                 plug.openBanMenu(invocateur);
             }
             else
             {
                invocateur.sendMessage("il n'existe pas !!");
             }
           }
           else if(e.getCurrentItem().getType().equals(Material.BARRIER))
           {
             //récupération des joueurs connécté dans le serveur
             plug.openBanMenu(invocateur); 
               
           }
        }
       
    }
    
    public void openComfirmenu(Player player,ItemStack banned, Player baned)
    {
        Inventory confirmenu = Bukkit.createInventory(player, 9,ChatColor.DARK_AQUA + "Confirmation de Ban");
        ItemStack confirm = new ItemStack(Material.NETHERITE_SWORD);
        ItemStack back = new ItemStack(Material.BARRIER);
        ItemMeta meta = banned.getItemMeta();
        ArrayList<String> loreArrayList = new ArrayList<>();
        loreArrayList = (ArrayList<String>)meta.getLore();
        loreArrayList.set(1,ChatColor.GREEN + "NON BANNI " + ChatColor.WHITE + "->" + ChatColor.RED + " BANNI");
        meta.setLore(loreArrayList);
        banned.setItemMeta(meta);
        confirmenu.addItem(confirm);
        confirmenu.setItem(8, back);
        confirmenu.setItem(4, banned);
        player.openInventory(confirmenu);
        
    }
    

}

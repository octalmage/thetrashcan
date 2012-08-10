package com.pr.ojectblue.Trashcan;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;



public class Trashcan extends JavaPlugin implements Listener{
	
	
	public void onEnable(){
		getLogger().info("The Trashcan 0.2 has been enabled!");
		getServer().getPluginManager().registerEvents(this, this);
		
		/*
		Creates the recipe to be trashcan shaped.
		o   o
		o   o
		o o o
		*/
		ShapedRecipe RECIPE = new ShapedRecipe(new ItemStack(Material.CAULDRON_ITEM,1)).shape("o o", "o o", "ooo").setIngredient('o', Material.COBBLESTONE);
		
		//Adds the recipe to the server. This is important.
		getServer().addRecipe(RECIPE);
		
	}
 
	public void onDisable(){
		getLogger().info("The Trashcan 0.2 has been disabled.");
	}

	
	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled=true)
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        //When the user right clicks a block.
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK)
        {
        	//Check to see if they clicked a cauldron, and if they did make sure they aren't holding a water bucket or a glass bottle.
        	//Thanks to Algent for coming up with a simple way to make the Cauldron still usable. 
            if (event.getClickedBlock().getType() == Material.CAULDRON && player.getItemInHand().getType() != Material.WATER_BUCKET && player.getItemInHand().getType() != Material.GLASS_BOTTLE) 
            {
            	//Opens the trashcan gui as an inventory.
            	Inventory inventory = Bukkit.createInventory(player, 36, "Trash Can");              
                player.openInventory(inventory);

            }
        }
	}
}
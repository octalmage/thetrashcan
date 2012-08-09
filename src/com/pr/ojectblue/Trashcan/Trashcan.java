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
		getLogger().info("Trashcan 0.1 has been enabled!");
		getServer().getPluginManager().registerEvents(this, this);
		ShapedRecipe RECIPE = new ShapedRecipe(new ItemStack(Material.CAULDRON_ITEM,1)).shape("o o", "o o", "ooo").setIngredient('o', Material.COBBLESTONE);
    	
		getServer().addRecipe(RECIPE);
		
	}
 
	public void onDisable(){
		getLogger().info("Trashcan 0.1 has been disabled.");
	}

	
	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled=true)
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK)
        {
            if (event.getClickedBlock().getType() == Material.CAULDRON) 
            {
            	Inventory inventory = Bukkit.createInventory(player, 36, "Trash Can");              
                InventoryView view = player.openInventory(inventory);

            }
        }
	}
}
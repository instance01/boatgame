package com.comze_instancelabs.boatgame;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
 
public class futask extends BukkitRunnable {

	private Player player;
	private Location locat;
	private boolean update = true;
	private int itemid = 0;
	private int amount = 0;
	
    public futask(Player pla, Location loc, boolean t) {
    	player = pla;
    	locat = loc;
    	update = t;
    }
    
    public futask(Player pla, Location loc, boolean t, int itemreward_itemid, int itemreward_amount) {
    	player = pla;
    	locat = loc;
    	update = t;
    	itemid = itemreward_itemid;
    	amount = itemreward_amount;
    }
 
    public void run() {
        player.updateInventory();
        player.getInventory().removeItem(new ItemStack(Material.SNOW_BALL, 64));
        player.getInventory().removeItem(new ItemStack(Material.SNOW_BALL, 64));
        player.getInventory().removeItem(new ItemStack(Material.SNOW_BALL, 64));
        if(update){
        	player.getInventory().setContents(Main.pinv.get(player));
        }
        player.updateInventory();
        if(itemid != 0){
        	player.getInventory().addItem(new ItemStack(Material.getMaterial(itemid), amount));
        	player.updateInventory();
        }
    	
        // What you want to schedule goes here
        tpaway(player, locat);
        
        player.updateInventory();
        player.getInventory().addItem(new ItemStack(Material.SNOW_BALL, 1));
        player.updateInventory();
        player.getInventory().removeItem(new ItemStack(Material.SNOW_BALL, 64));
        player.getInventory().removeItem(new ItemStack(Material.SNOW_BALL, 64));
        player.getInventory().removeItem(new ItemStack(Material.SNOW_BALL, 64));
        player.getInventory().removeItem(new ItemStack(Material.SNOW_BALL, 1));
        player.updateInventory();
    }
 
    
    public void tpaway(Player pla, Location loc){
    	pla.teleport(loc);
    }
}
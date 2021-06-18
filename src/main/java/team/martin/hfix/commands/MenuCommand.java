package team.martin.hfix.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof ConsoleCommandSender){
            System.out.println(ChatColor.RED + "[hFix] You are not a player to execute the command.");
            return false;
        }

        Player p = (Player) sender;
        if (sender.hasPermission("hfix.admin")){
            Inventory menu = Bukkit.createInventory(null, 9, ChatColor.RED + "hFix Menu");
            menu.addItem(this.newItemStack("ClearChunk's", "Clear all chunks that are loaded.", Material.GRASS_BLOCK));
            menu.addItem(this.newItemStack("ClearMob's", "Clean all mobs.", Material.DIAMOND_SWORD));
//            menu.addItem(this.newItemStack("ClearItem's", "Clear all items on floor.", Material.DIRT)); TODO RELEASE 2.0
            p.openInventory(menu);
            return true;
        } else {
            p.sendMessage(ChatColor.RED + "[hFix] You do not have permission to access this command.");
            return false;
        }
    }

    private ItemStack newItemStack(String displayName, String lore, Material material){
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN + displayName);
        itemMeta.setLore(Collections.singletonList(ChatColor.RED + lore));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}

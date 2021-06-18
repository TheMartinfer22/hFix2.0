package team.martin.hfix.events.extras;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import team.martin.hfix.functions.ClearChunksFunction;
import team.martin.hfix.functions.ClearMobsFunction;

public class MenuListenerEvent implements Listener {

    @EventHandler
    public void verifyMenu(InventoryClickEvent event){
        if (event.getWhoClicked() instanceof Player){
            Player p = (Player) event.getWhoClicked();
            if (event.getClickedInventory() != null && event.getView().getTitle().equals(ChatColor.RED + "hFix Menu")){
                String done = "was performed successfully, check the console.";
                switch (event.getSlot()){
                    case 0: new ClearChunksFunction().run(); p.closeInventory(); p.sendMessage(ChatColor.GREEN + "[hFix] ClearChunks " + done); break;
                    case 1: new ClearMobsFunction().run(); p.closeInventory(); p.sendMessage(ChatColor.GREEN + "[hFix] ClearMobs " + done); break;
//                    case 2: System.out.println("3"); break; TODO RELEASE 2.0
//                    case 3: System.out.println("4"); break;
//                    case 4: System.out.println("5"); break;
//                    case 5: System.out.println("6"); break;
//                    case 6: System.out.println("7"); break;
//                    case 7: System.out.println("8"); break;
//                    case 8: System.out.println("9"); break;
                }

                if (event.isRightClick() || event.isLeftClick()){
                    event.setCancelled(true);
                }
            }
        }
    }
}

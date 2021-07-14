package team.martin.hfix.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import team.martin.hfix.functions.ClearChunksFunction;
import team.martin.hfix.functions.ClearDropItensFunction;
import team.martin.hfix.functions.ClearMobsFunction;

public class MenuCommandChat implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (args.length == 0){
            sender.sendMessage(ChatColor.RED + "--------------------");
            sender.sendMessage(ChatColor.RED + "Menu de comandos hFix");
            sender.sendMessage(ChatColor.RED + "--------------------");
            sender.sendMessage(ChatColor.RED + "/hfix " + ChatColor.YELLOW + " - Veja esse menu.");
            sender.sendMessage(ChatColor.RED + "/hfix killchunks " + ChatColor.YELLOW + " - Limpe todas as chunks que estão carregadas sem jogadores.");
            sender.sendMessage(ChatColor.RED + "/hfix killitens" + ChatColor.YELLOW + " - Limpe todos os itens do chão de todas dimensões.");
            sender.sendMessage(ChatColor.RED + "/hfix killmobs" + ChatColor.YELLOW + " - Limpe todos os monstros e animais de todos mundos.");
            sender.sendMessage(ChatColor.RED + "/hfix hand" + ChatColor.YELLOW + " - Veja o ID do item que está em sua mão.");
            return true;
        }

        switch (args[0]){
            case "killchunks":
                sender.sendMessage(ChatColor.YELLOW + "[hFix] " + ChatColor.GREEN + "Você descarregou todas as chunks.");
                if (args.length == 2){
                    try {
                        new ClearChunksFunction().run(args[1]);
                        break;
                    } catch (NullPointerException e){
                        sender.sendMessage(ChatColor.YELLOW + "[hFix] " + ChatColor.RED + "Você deve utilizar um nome de mundo válido.");
                        break;
                    }
                }
                new ClearChunksFunction().run();
                break;

            case "killmobs":
                sender.sendMessage(ChatColor.YELLOW + "[hFix] " + ChatColor.GREEN + "Você limpou todos os animais e monstros.");
                try {
                    if (args.length == 2){
                        new ClearMobsFunction().run(args[1]);
                        break;
                    }
                } catch (NullPointerException e){
                    sender.sendMessage(ChatColor.YELLOW + "[hFix] " + ChatColor.RED + "Você deve utilizar um nome de mundo válido.");
                    break;
                }
                new ClearMobsFunction().run();
                break;

            case "hand":
                Player p = (Player) sender;
                sender.sendMessage(ChatColor.YELLOW + "[hFix] " + ChatColor.GREEN + p.getPlayer().getInventory().getItemInMainHand().getType());
                break;

            case "killitens":
                sender.sendMessage(ChatColor.YELLOW + "[hFix] " + ChatColor.GREEN + "Você limpou todos os itens do chão.");
                if (args.length == 2){
                    try {
                        new ClearDropItensFunction().run(args[1]);
                        break;
                    } catch (NullPointerException e){
                        sender.sendMessage(ChatColor.YELLOW + "[hFix] " + ChatColor.RED + "Você deve utilizar um nome de mundo válido.");
                        break;
                    }
                }
                new ClearDropItensFunction().run();
                break;
        }
        return false;
    }
}

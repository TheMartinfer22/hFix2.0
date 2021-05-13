package team.martin.hfix.bloqueios;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import team.martin.hfix.util.ConfigUtils;

/*
 * Esses eventos estão como alta prioridade de execução para que possa ler cada ação,
 * Não causará problemas de desempenho.
 *
 * TODO WARNING: ESSA FUNCIONALIDADE ESTÁ EM TESTES, ALGUNS TIPOS DE DANOS DO MINECRAFT EXECUTAM EM VOID, ENTÃO CASO UTILIZE MODS DESABILITE ISSO!
 */

public class NoVoidDamage extends ConfigUtils implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void antiDanoDoVoid(EntityDamageEvent event){

        if (event.getEntity().hasPermission(getPermissaoAntiVoid())){ // Verificação caso o jogador possua a permissão.
            event.setCancelled(true); // Cancelar o evento de dano por void.
        }
    }

}

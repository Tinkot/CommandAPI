package hypergen.online.spigotplugin.commandbuilder.components;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerListComponent {
    private final List<String> names;

    public PlayerListComponent() {
        Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        names = new ArrayList<>(players.size());
        for(Player player : players) {
            this.names.add(player.getName());
        }
    }

    public List<String> getNames() {
        return names;
    }
}

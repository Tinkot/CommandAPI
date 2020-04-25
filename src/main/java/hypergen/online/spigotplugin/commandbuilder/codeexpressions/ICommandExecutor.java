package hypergen.online.spigotplugin.commandbuilder.codeexpressions;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public interface ICommandExecutor {
    void onExecute(CommandExecutor player, String[] args);
}

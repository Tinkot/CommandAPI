package hypergen.online.spigotplugin.commandbuilder.implementable;

import org.bukkit.command.CommandExecutor;

public interface CommandPerformer {
    void onCommand(CommandExecutor player, String[] args);
}

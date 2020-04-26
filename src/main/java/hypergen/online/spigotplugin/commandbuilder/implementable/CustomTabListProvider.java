package hypergen.online.spigotplugin.commandbuilder.implementable;

import org.bukkit.command.CommandSender;

import java.util.List;

public interface CustomTabListProvider {
    List<String> onTabListRequest(CommandSender sender, String argument) ;
}

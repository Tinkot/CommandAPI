package hypergen.online.spigotplugin.commandbuilder.impl.executors;

import hypergen.online.spigotplugin.commandbuilder.Argument;
import hypergen.online.spigotplugin.commandbuilder.implementable.CommandPerformer;
import hypergen.online.spigotplugin.commandbuilder.implementable.CustomTabListProvider;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

public class GiveCommandPerformer implements CommandPerformer, CustomTabListProvider {
    @Override
    public void onCommand(CommandExecutor executor, String[] args) {

    }

    @Override
    public List<String> onTabListRequest(CommandSender sender, String labelSummary) {
        switch(labelSummary) {
            case "give.item":
                return Arrays.asList(new String[]{"diamond_sword", "iron_sword"});
            case "give.item.amount.modifier":
                return Arrays.asList(new String[]{"unbreaking", "sharpness"});
        }
        return null;
    }
}

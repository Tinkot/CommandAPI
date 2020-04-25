package hypergen.online.spigotplugin.commandbuilder;

import hypergen.online.spigotplugin.commandbuilder.codeexpressions.ICommandExecutor;
import hypergen.online.spigotplugin.commandbuilder.components.CommandComponent;
import hypergen.online.spigotplugin.commandbuilder.components.ErrorComponent;

import java.util.List;

public class Command {
    public Command(CommandComponent command, ErrorComponent errorComponent, List<Argument> argumentList, Class<? extends ICommandExecutor> commandExecutor) {

    }
}

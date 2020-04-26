package hypergen.online.spigotplugin.commandbuilder;

import hypergen.online.spigotplugin.commandbuilder.implementable.CommandPerformer;
import hypergen.online.spigotplugin.commandbuilder.components.CommandComponent;
import hypergen.online.spigotplugin.commandbuilder.components.ErrorComponent;

import java.util.List;

public class Command {
    private final CommandComponent commandComponent;
    private final ErrorComponent errorComponent;
    private final List<Argument> argumentList;
    private final CommandPerformer commandExecutor;

    public Command(CommandComponent commandComponent, ErrorComponent errorComponent, List<Argument> argumentList, CommandPerformer commandExecutor) {
        this.commandComponent = commandComponent;
        this.errorComponent = errorComponent;
        this.argumentList = argumentList;
        this.commandExecutor = commandExecutor;
    }
}

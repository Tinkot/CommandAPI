package hypergen.online.spigotplugin.commandbuilder;

import hypergen.online.spigotplugin.commandbuilder.implementable.CommandPerformer;
import hypergen.online.spigotplugin.commandbuilder.components.*;

import java.util.ArrayList;
import java.util.List;

public class CommandBuilder {
    private final CommandComponent commandComponent;
    private final ErrorComponent errorComponent;
    private List<Argument> argumentList = new ArrayList<>();

    public CommandBuilder(CommandComponent commandComponent, ErrorComponent errorComponent) {
        this.commandComponent = commandComponent;
        this.errorComponent = errorComponent;
    }

    public Command build(CommandPerformer commandExecutor) {
        return new Command(commandComponent, errorComponent, argumentList, commandExecutor);
    }


    public CommandBuilder argument(LabelComponent label, TabCompleterComponent tabCompleter, ErrorComponent error) {
        Argument argument = new Argument(label, tabCompleter, error);
        argumentList.add(argument);
        return this;
    }
}

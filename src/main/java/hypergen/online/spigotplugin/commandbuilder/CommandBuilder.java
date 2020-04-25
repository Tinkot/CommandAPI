package hypergen.online.spigotplugin.commandbuilder;

import hypergen.online.spigotplugin.commandbuilder.codeexpressions.ICommandExecutor;
import hypergen.online.spigotplugin.commandbuilder.components.*;

import java.util.ArrayList;
import java.util.List;

public class CommandBuilder {
    private final CommandComponent command;
    private final ErrorComponent errorComponent;
    private List<Argument> argumentList = new ArrayList<>();

    public CommandBuilder(CommandComponent command, ErrorComponent errorComponent) {
        this.command = command;
        this.errorComponent = errorComponent;
    }

    public Command build(Class<? extends ICommandExecutor> commandExecutor) {
        new Command(command, errorComponent, argumentList, commandExecutor);
    }


    public CommandBuilder argument(LabelComponent label, TabCompleterComponent tabCompleter, ErrorComponent error) {
        Argument argument = new Argument(label, tabCompleter, error);
        argumentList.add(argument);
        return this;
    }
}

package hypergen.online.spigotplugin.commandbuilder;

import hypergen.online.spigotplugin.commandbuilder.implementable.CommandPerformer;
import hypergen.online.spigotplugin.commandbuilder.components.*;

import java.util.ArrayList;
import java.util.List;

public class CommandBuilder {
    private final RootComponent root;

    public CommandBuilder(RootComponent root) {
        this.root = root;
    }

    public Command build(CommandPerformer commandPerformer) {
        return new Command(root, commandPerformer);
    }

}

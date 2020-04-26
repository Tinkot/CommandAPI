package hypergen.online.spigotplugin.commandbuilder;

import hypergen.online.spigotplugin.commandbuilder.components.ErrorComponent;
import hypergen.online.spigotplugin.commandbuilder.components.TabCompleterComponent;
import hypergen.online.spigotplugin.commandbuilder.components.LabelComponent;

public class Argument {
    private final LabelComponent label;
    private final TabCompleterComponent tabCompleter;
    private final ErrorComponent error;

    public Argument(LabelComponent label, TabCompleterComponent tabCompleter, ErrorComponent error) {
        this.label = label;
        this.tabCompleter = tabCompleter;
        this.error = error;
    }

    public LabelComponent getLabel() {
        return label;
    }

    public TabCompleterComponent getTabCompleter() {
        return tabCompleter;
    }

    public ErrorComponent getError() {
        return error;
    }


}

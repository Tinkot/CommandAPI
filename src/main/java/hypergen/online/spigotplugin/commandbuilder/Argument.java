package hypergen.online.spigotplugin.commandbuilder;

import hypergen.online.spigotplugin.commandbuilder.components.ErrorComponent;
import hypergen.online.spigotplugin.commandbuilder.components.LabelComponent;
import hypergen.online.spigotplugin.commandbuilder.components.WhenComponent;

public class Argument {
    private final LabelComponent label;
    private final ErrorComponent error;
    private final WhenComponent[] whens;
    public Object addDecision;

    public Argument(LabelComponent label, ErrorComponent error, WhenComponent[] whens) {
        this.label = label;
        this.error = error;
        this.whens = whens;
    }


    public LabelComponent getLabel() {
        return label;
    }

    public ErrorComponent getError() {
        return error;
    }
}

package hypergen.online.spigotplugin.commandbuilder.components;

public class LabelComponent {
    private final String label;

    public LabelComponent(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return getLabel();
    }
}

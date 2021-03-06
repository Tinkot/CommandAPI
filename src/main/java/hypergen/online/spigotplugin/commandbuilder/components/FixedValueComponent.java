package hypergen.online.spigotplugin.commandbuilder.components;

public class FixedValueComponent implements TabCompleterComponent {
    private final String[] values;

    public FixedValueComponent(String... values) {
        this.values = values;
    }

    public String[] getValues() {
        return values;
    }
}

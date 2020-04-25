package hypergen.online.spigotplugin.commandbuilder.components;

public class CommandComponent {
    private final String[] commands;

    public CommandComponent(String... commands) {
        this.commands = commands;
    }

    public String[] getCommands() {
        return commands;
    }
}

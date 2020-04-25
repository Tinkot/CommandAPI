package hypergen.online.spigotplugin;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import hypergen.online.configfactory.ConfigFactory;
import hypergen.online.spigotplugin.commandbuilder.CommandBuilder;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandAPI extends JavaPlugin {
    @Override
    public void onEnable() {
        ConfigFactory configFactory = ConfigFactory.getInstance();
        Config config = configFactory.getConfig(getDataFolder(), Config.class);
        ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();
        protocolManager.addPacketListener(new TestPacketListener(this));
//        Bukkit.getServer().getPluginCommand().get
    }

    private void registerListenerds() {
        getServer().getPluginManager().registerEvent(new );
    }


    private void createCommand() {
        CommandBuilder = new CommandBuilder(command("give","gift"), error("a player must be specified"))
                .argument(label("players"), players(), error("incorrect player name"))
                .argument(label("item"),    fixed("dirt", "stone"), code(runnable1), error("[<value>] is a incorrect item"))
                .argument(label("amount"),  fixed("dirt", "stone"), code(runnable1), error("[<value>] is a incorrect item"));

        registerCommand(CommandBuilder.build(GiveCommandExecutor.class));
    }
}


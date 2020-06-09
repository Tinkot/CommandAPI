package hypergen.online.spigotplugin;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import hypergen.online.configfactory.ConfigFactory;
import org.bukkit.plugin.java.JavaPlugin;

import static com.mojang.brigadier.arguments.BoolArgumentType.bool;
import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static com.mojang.brigadier.arguments.StringArgumentType.string;
import static com.mojang.brigadier.builder.LiteralArgumentBuilder.literal;
import static com.mojang.brigadier.builder.RequiredArgumentBuilder.argument;

public class CommandAPI extends JavaPlugin {

    private BrigadierManager brigadierManager;

    @Override
    public void onEnable() {
        ConfigFactory configFactory = ConfigFactory.getInstance();
        Config config = configFactory.getConfig(getDataFolder(), Config.class);
        ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();
        brigadierManager = new BrigadierManager(this);
        protocolManager.addPacketListener(brigadierManager);
        registerCommand();
    }


    private void registerCommand() {
        LiteralArgumentBuilder command = literal("foo")
                .then(argument("text here", string())
                        .then(argument("true or false", bool())
                                .then(argument("a number", integer())
                                        .then(argument("a string", string()))
                                )
                        )
                );
        brigadierManager.registerBrigadierCommand(command);
    }
}


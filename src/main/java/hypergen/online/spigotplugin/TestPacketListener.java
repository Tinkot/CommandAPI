package hypergen.online.spigotplugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.brigadier.tree.RootCommandNode;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

import static com.mojang.brigadier.arguments.BoolArgumentType.*;
import static com.mojang.brigadier.arguments.DoubleArgumentType.*;
import static com.mojang.brigadier.arguments.FloatArgumentType.*;
import static com.mojang.brigadier.arguments.IntegerArgumentType.*;
import static com.mojang.brigadier.arguments.LongArgumentType.*;
import static com.mojang.brigadier.arguments.StringArgumentType.*;
import static com.mojang.brigadier.builder.LiteralArgumentBuilder.*;
import static com.mojang.brigadier.builder.RequiredArgumentBuilder.*;

public class TestPacketListener extends PacketAdapter {

    public TestPacketListener(JavaPlugin plugin) {
        super(plugin, PacketType.Play.Server.COMMANDS);
    }

    @Override
    public void onPacketSending(PacketEvent event) {
        register(event, createCommand());
    }

    private LiteralArgumentBuilder<Object> createCommand() {
        return literal("foo")
                .then(argument("text here", string())
                        .then(argument("true or false", bool())
                                .then(argument("a number", integer())
                                        .then(argument("a string", string()))
                                        .then(argument("a string", list)

                                )
                        )
                );
    }

    private LiteralCommandNode register(PacketEvent event, LiteralArgumentBuilder command) {
        LiteralCommandNode build = command.build();
        RootCommandNode rootCommandNode = getRootCommandNode(event);
        rootCommandNode.addChild(command.build());
        return build;
    }


    private RootCommandNode getRootCommandNode(PacketEvent event) {
        final StructureModifier<RootCommandNode> data = event.getPacket().getSpecificModifier(RootCommandNode.class);
        List<RootCommandNode> rootCommandNode = data.getValues();
        // Only one field should ever exist in the nms class net.minecraft.server.v1_15_R1.PacketPlayOutCommands
        // so it is fine to iterate and directly return;
        for (RootCommandNode<Object> value : rootCommandNode) {
            return value;
        }
        throw new NullPointerException("Could not find any RootCommandNode");
    }
}

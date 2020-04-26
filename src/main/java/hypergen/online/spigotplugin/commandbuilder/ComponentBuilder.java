package hypergen.online.spigotplugin.commandbuilder;

import hypergen.online.spigotplugin.commandbuilder.components.*;
import hypergen.online.spigotplugin.commandbuilder.impl.performers.PermissionCommandPerformer;
import hypergen.online.spigotplugin.commandbuilder.impl.performers.TimeCommandPerformer;


public class ComponentBuilder {

    public static CommandsComponent command(String command) {
        return new CommandsComponent(new String[] {command});
    }

    public static CommandsComponent commands(String... commands) {
        return new CommandsComponent(commands);
    }

    public static LabelComponent label(String label) {
        return new LabelComponent(label);
    }

    public static ErrorComponent error(String error) {
        return new ErrorComponent(error);
    }

    public static PrimitiveUserEntry integer() {
        return integer(null, null);
    }

    public static PrimitiveUserEntry integer(Integer min, Integer max) {
        return new IntegerComponent(min, max);

    }

    public static WhenComponent when(PrimitiveUserEntry when, ExecuteComponent execute) {
        return new WhenComponent(when, execute);
    }

    private static RootComponent root(CommandsComponent commands, ErrorComponent error, ExecuteComponent execute, ArgumentComponent argument) {
        return new RootComponent(commands, error, execute, argument);
    }

    private static RootComponent root(CommandsComponent commands, ErrorComponent error, ArgumentComponent argument) {
        return new RootComponent(commands, error, argument);
    }

    private static WhenComponent when(LabelComponent label, ErrorComponent error, ArgumentComponent argument) {
        return new WhenComponent(label, error, argument);
    }

    public static WhenComponent when(String when, ArgumentComponent argument) {
        return new WhenComponent(when, argument);
    }

    public static WhenComponent when(String when, ExecuteComponent execute) {
        return new WhenComponent(when, execute);
    }

    private WhenComponent when(PlayerListComponent anyPlayer, LabelComponent permission, ExecuteComponent execute) {
        return new WhenComponent(anyPlayer, permission, execute);
    }

    private static PlayerListComponent anyPlayer() {
        return new PlayerListComponent();
    }

    private ExecuteComponent execute() {
        return new ExecuteComponent();
    }

    public static ArgumentComponent argument(LabelComponent label, ErrorComponent error, ExecuteComponent execute, WhenComponent... whens) {
        return new ArgumentComponent(label, error, execute, whens);
    }

    public static ArgumentComponent argument(LabelComponent label, ErrorComponent error, WhenComponent... whens) {
        return new ArgumentComponent(label, error, whens);
    }





    public void test() {
        TimeCommandPerformer timeCommandPerformer = new TimeCommandPerformer();
        Command giveCommand = new CommandBuilder(
                root(
                        commands("time", "clock"),
                        error("you need to provide a action"),
                        argument(
                                label("action"),
                                error("not a valid action"),
                                execute(),
                                when("set",
                                        argument(
                                                label("time"),
                                                error("invalid time"),
                                                when("day",
                                                        execute()),
                                                when("midnight",
                                                        execute()),
                                                when("night",
                                                        execute()),
                                                when("noon",
                                                        execute()),
                                                when(integer(),
                                                        execute())
                                        )
                                ),
                                when("add",
                                        argument(
                                                label("time"),
                                                error("invalid time"),
                                                when(integer(),
                                                        execute())
                                        )
                                ),
                                when("query",
                                        argument(
                                                label("format"),
                                                error("invalid time format"),
                                                when("day",
                                                        execute()),
                                                when("daytime",
                                                        execute()),
                                                when("gametime",
                                                        execute())
                                        )
                                )
                        )
                )
        ).build(timeCommandPerformer);

        PermissionCommandPerformer permissionCommandPerformer = new PermissionCommandPerformer();
        Command command = new CommandBuilder(
                when(
                        label("hgperms"),
                        error("you need to provide a action"),
                        argument(
                                label("target-type"),
                                error("not a valid action"),
                                execute(),
                                when("player",
                                        label("player"),
                                        error("player does not exist"),
                                        argument(
                                                label("action"),
                                                when(anyPlayer(),
                                                        label("permission"),
                                                        argument(

                                                        )
                                                )
                                        )
                                ),
                                when("group",
                                        argument(
                                                label("time"),
                                                error("invalid time"),
                                                when(integer(),
                                                        execute())
                                        )
                                )
                        )
                )
        ).build(performer);
    }
}
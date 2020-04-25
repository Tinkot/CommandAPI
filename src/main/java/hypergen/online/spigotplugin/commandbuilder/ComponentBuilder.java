package hypergen.online.spigotplugin.commandbuilder;


import hypergen.online.spigotplugin.commandbuilder.codeexpressions.ICommandExecutor;
import hypergen.online.spigotplugin.commandbuilder.components.*;
import hypergen.online.spigotplugin.commandbuilder.impl.executors.GiveCommandExecutor;

import java.util.List;


public class ComponentBuilder {

    public static CommandComponent command(String... commands) {
        return new CommandComponent(commands);
    }

    public static LabelComponent label(String label) {
        return new LabelComponent(label);
    }

    public static ErrorComponent error(String error) {
        return new ErrorComponent(error);
    }

    public static ExecutorComponent argumentExecutor(Class<? extends ICommandExecutor> argumentExecutorClass) { return new ExecutorComponent(argumentExecutorClass); }

    public static TabCompleterComponent playerList() {
        return new PlayerListComponent();
    }

    public static TabCompleterComponent fixedList(String... values) {
        return new FixedValueComponent(values);
    }

    public static TabCompleterComponent integer() {
        return integer(null, null);
    }

    public static TabCompleterComponent integer(Integer min, Integer max) {
        return new IntegerComponent(min, max);
    }

    private static TabCompleterComponent flexibleList(List list) { return new FlexibleListComponent(list); }

    private static TabCompleterComponent conditionalList() { return null; }

    private static void test() {
        Command command = new CommandBuilder(command("give", "gift"), error("a player must be specified"))
                .argument(label("player"),  playerList(),                         error("player does not exists."))
                .argument(label("item"),    fixedList("dirt", "stone"),   error("[<value>] is a incorrect item"))
                .argument(label("amount"),  integer(0,255),                       error("[<value>] is a not an integer"))
                .build(GiveCommandExecutor.class)
                ;
//                .argument(label("item"),    flexibleList(null), argumentExecutor(null), error("[<value>] is a incorrect item"))
//                .argument(label("item"),    conditionalList(null, condition), argumentExecutor(null), error("[<value>] is a incorrect item"))
    }

    private static int someMethod() { return 1;
    }
}

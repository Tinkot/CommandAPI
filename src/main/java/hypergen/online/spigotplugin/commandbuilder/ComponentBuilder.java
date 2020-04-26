package hypergen.online.spigotplugin.commandbuilder;

import hypergen.online.spigotplugin.commandbuilder.implementable.CustomTabListProvider;
import hypergen.online.spigotplugin.commandbuilder.components.*;
import hypergen.online.spigotplugin.commandbuilder.impl.executors.GiveCommandPerformer;


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

    private static TabCompleterComponent customList(CustomTabListProvider customTabListProvider) { return new CustomListComponent(customTabListProvider); }

    private static TabCompleterComponent conditionalList() { return null; }

    public void test() {
        GiveCommandPerformer executor = new GiveCommandPerformer();
        Command command = new CommandBuilder(command("give", "gift"), error("a player must be specified"))
                .argument(label("player"),  playerList(),                         error("player does not exists."))
                .argument(label("item"),    fixedList("dirt", "stone"),   error("[<value>] is a incorrect item"))
                .argument(label("amount"),  integer(0,255),                       error("[<value>] is a not an integer"))
                .argument(label("item"),    customList(executor),                 error("[<value>] is a incorrect item"))
                .build(executor)
                ;
//                .argument(label("item"),    flexibleList(null), argumentExecutor(null), error("[<value>] is a incorrect item"))
    }
}

package hypergen.online.spigotplugin.commandbuilder.components;

import hypergen.online.spigotplugin.commandbuilder.codeexpressions.ICommandExecutor;

public class ExecutorComponent {
    private final Class<? extends ICommandExecutor> argumentExecutor;

    public ExecutorComponent(Class<? extends ICommandExecutor> argumentExecutor) {
        this.argumentExecutor = argumentExecutor;
    }

    public Class<? extends ICommandExecutor> getArgumentExecutor() {
        return argumentExecutor;
    }
}

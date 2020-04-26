package hypergen.online.spigotplugin.commandbuilder.components;

import hypergen.online.spigotplugin.commandbuilder.implementable.CustomTabListProvider;

public class CustomListComponent {
    private final CustomTabListProvider customTabListProvider;

    public CustomListComponent(CustomTabListProvider customTabListProvider) {
        this.customTabListProvider = customTabListProvider;
    }

    public CustomTabListProvider getCustomTabListProvider() {
        return customTabListProvider;
    }
}

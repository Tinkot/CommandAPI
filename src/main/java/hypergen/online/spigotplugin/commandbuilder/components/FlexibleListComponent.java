package hypergen.online.spigotplugin.commandbuilder.components;

import java.util.List;

public class FlexibleListComponent implements TabCompleterComponent {
    private final List<String> editableList;

    public FlexibleListComponent(List<String> editableList) {
        this.editableList = editableList;
    }

    public List<String> getEditableList() {
        return editableList;
    }
}

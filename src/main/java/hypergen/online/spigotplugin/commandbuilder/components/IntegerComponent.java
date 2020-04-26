package hypergen.online.spigotplugin.commandbuilder.components;

public class IntegerComponent implements PrimitiveUserEntry {
    private int min = -2147483648;
    private int max = 2147483647;

    public IntegerComponent() {
    }

    public IntegerComponent(Integer min, Integer max) {
        if(min != null) {
            this.min = min;
        }
        if(max != null) {
            this.max = max;
        }
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}

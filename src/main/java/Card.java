public record Card(int value, int color) {

    @Override
    public String toString() {
        String displayColor = "";
        switch (color) {
            case 0 -> displayColor = "Red";
            case 1 -> displayColor = "Yellow";
            case 2 -> displayColor = "Blue";
            case 3 -> displayColor = "Green";
            case 4 -> displayColor = "Wild Card";
        }
        String displayValue = "";
        if (value < 10) displayValue = String.valueOf(value);
        displayValue = switch (value) {
            case 10 -> "skip";
            case 11 -> "reverse";
            case 12 -> "draw two";
            case 13 -> "wild";
            case 14 -> "draw four";
            default -> displayValue;
        };

        return String.format("[%s,%s]", displayValue, displayColor);
    }
}

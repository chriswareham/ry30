package net.chriswareham.ry30;


public enum FilterType {

    THRU("Off"),

    LPF12("LPF 12db"),

    LPF24("LPF 24db"),

    HPF12("HPF 12db"),

    HPF24("HPF 24db");

    private final String description;

    FilterType(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}

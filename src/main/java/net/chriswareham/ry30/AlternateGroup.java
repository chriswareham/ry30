package net.chriswareham.ry30;

public enum AlternateGroup {

    OFF("Off"),

    ONE("One"),

    TWO("Two"),

    THREE("Three"),

    FOUR("Four"),

    FIVE("Five"),

    SIX("Six"),

    SEVEN("Seven");

    private final String description;

    AlternateGroup(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}

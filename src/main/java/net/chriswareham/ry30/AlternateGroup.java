package net.chriswareham.ry30;

/**
 * This enumeration describes the possible alternate groups for a voice.
 */
public enum AlternateGroup {
    /**
     * No alternate group.
     */
    OFF("Off"),

    /**
     * The first alternate group.
     */
    ONE("One"),

    /**
     * The second alternate group.
     */
    TWO("Two"),

    /**
     * The third alternate group.
     */
    THREE("Three"),

    /**
     * The fourth alternate group.
     */
    FOUR("Four"),

    /**
     * The fifth alternate group.
     */
    FIVE("Five"),

    /**
     * The sixth alternate group.
     */
    SIX("Six"),

    /**
     * The seventh alternate group.
     */
    SEVEN("Seven");

    /**
     * The description of the enumeration value.
     */
    private final String description;

    /**
     * Construct an instance of an enumeration value.
     *
     * @param description the description of the enumeration value
     */
    AlternateGroup(final String description) {
        this.description = description;
    }

    /**
     * Get the description of the enumeration value.
     *
     * @return the description of the enumeration value
     */
    @Override
    public String toString() {
        return description;
    }
}

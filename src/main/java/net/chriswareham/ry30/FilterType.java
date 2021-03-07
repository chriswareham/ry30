package net.chriswareham.ry30;

/**
 * This enumeration describes the possible filter types for an element.
 */
public enum FilterType {
    /**
     * The pass through filter type.
     */
    THRU("Off"),

    /**
     * The 12db per octave low pass filter.
     */
    LPF12("LPF 12db"),

    /**
     * The 24db per octave low pass filter.
     */
    LPF24("LPF 24db"),

    /**
     * The 12db per octave high pass filter.
     */
    HPF12("HPF 12db"),

    /**
     * The 24db per octave high pass filter.
     */
    HPF24("HPF 24db");

    /**
     * The description of the enumeration value.
     */
    private final String description;

    /**
     * Construct an instance of an enumeration value.
     *
     * @param description the description of the enumeration value
     */
    FilterType(final String description) {
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

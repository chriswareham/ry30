package net.chriswareham.ry30;

/**
 * This enumeration describes the possible output assignment for a voice.
 */
public enum OutputAssign {
    /**
     * The stereo output assignment.
     */
    STEREO("Stereo"),

    /**
     * The stereo and individual output one assignment.
     */
    STEREO_INDV1("Stereo & Individual 1"),

    /**
     * The stereo and individual output two assignment.
     */
    STEREO_INDV2("Stereo & Individual 2"),

    /**
     * The individual output one assignment.
     */
    INDV1("Individual 1"),

    /**
     * The individual output two assignment.
     */
    INDV2("Individual 2"),

    /**
     * The individual outputs one and two assignment.
     */
    INDV1_INDV2("Individual 1 & 2");

    /**
     * The description of the enumeration value.
     */
    private final String description;

    /**
     * Construct an instance of an enumeration value.
     *
     * @param description the description of the enumeration value
     */
    OutputAssign(final String description) {
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

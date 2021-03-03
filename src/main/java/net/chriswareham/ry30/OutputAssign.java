package net.chriswareham.ry30;

public enum OutputAssign {

    STEREO("Stereo"),

    STEREO_INDV1("Stereo & Individual 1"),

    STEREO_INDV2("Stereo & Individual 2"),

    INDV1("Individual 1"),

    INDV2("Individual 2"),

    INDV1_INDV2("Individual 1 & 2");

    private final String description;

    OutputAssign(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}

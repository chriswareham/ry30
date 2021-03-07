package net.chriswareham.ry30;

/**
 * This enumeration describes the possible waves for an element.
 *
 * <p>All waves apart from the last six can be reversed.</p>
 */
public enum Wave {

    //
    // KICKS
    //

    /**
     * Analogue kick.
     */
    BD_ANLG("Analogue kick"),

    /**
     * Dry kick (heavy).
     */
    BD_DRYH("Dry kick (heavy)"),

    /**
     * Dry kick (tight 1).
     */
    BD_DRYT1("Dry kick (tight 1)"),

    /**
     * Dry kick (tight 2).
     */
    BD_DRYT2("Dry kick (tight 2)"),

    /**
     * Gated kick 1.
     */
    BD_GATE1("Gated kick 1"),

    /**
     * Gated kick 2.
     */
    BD_GATE2("Gated kick 2"),

    /**
     * Processed kick 1.
     */
    BD_PROC1("Processed kick 1"),

    /**
     * Processed kick 2.
     */
    BD_PROC2("Processed kick 2"),

    /**
     * Processed kick 3.
     */
    BD_PROC3("Processed kick 3"),

    /**
     * Room kick.
     */
    BD_ROOM("Room kick"),

    /**
     * SFX kick.
     */
    BD_SFX("SFX kick"),

    /**
     * Techno kick.
     */
    BD_TEKNO("Techno kick"),

    //
    // SNARES
    //

    /**
     * Analogue snare 1.
     */
    SD_ANLG1("Analogue snare 1"),

    /**
     * Analogue snare 2.
     */
    SD_ANLG2("Analogue snare 2"),

    /**
     * Dry snare (heavy).
     */
    SD_DRYH("Dry snare (heavy)"),

    /**
     * Dry snare (tight 1).
     */
    SD_DRYT1("Dry snare (tight 1)"),

    /**
     * Dry snare (tight 2).
     */
    SD_DRYT2("Dry snare (tight 2)"),

    /**
     * Dry snare (tight 3).
     */
    SD_DRYT3("Dry snare (tight 3)"),

    /**
     * Gated snare 1.
     */
    SD_GATE1("Gated snare 1"),

    /**
     * Gated snare 2.
     */
    SD_GATE2("Gated snare 2"),

    /**
     * Gated snare 3.
     */
    SD_GATE3("Gated snare 3"),

    /**
     * Processed snare.
     */
    SD_PROCS("Processed snare"),

    /**
     * Reverb snare.
     */
    SD_REVRB("Reverb snare"),

    /**
     * Rim shot.
     */
    SD_RIM("Rim shot"),

    /**
     * Room snare 1.
     */
    SD_ROOM1("Room snare 1"),

    /**
     * Room snare 2.
     */
    SD_ROOM2("Room snare 2"),

    /**
     * Room snare 3.
     */
    SD_ROOM3("Room snare 3"),

    /**
     * Room snare 4.
     */
    SD_ROOM4("Room snare 4"),

    /**
     * Room snare 5.
     */
    SD_ROOM5("Room snare 5"),

    /**
     * Side stick.
     */
    SD_SIDE("Side stick"),

    /**
     * Techno snare.
     */
    SD_TEKNO("Techno snare"),

    //
    // HIHATS
    //

    /**
     * Analogue hi-hat.
     */
    HH_ANLG("Analogue hi-hat"),

    /**
     * Closed hi-hat (soft).
     */
    HH_CLS1A("Closed hi-hat (soft)"),

    /**
     * Closed hi-hat (hard).
     */
    HH_CLS1B("Closed hi-hat (hard)"),

    /**
     * Closed hi-hat (set 2).
     */
    HH_CLS2("Closed hi-hat (set 2)"),

    /**
     * Open hi-hat.
     */
    HH_OPN1("Open hi-hat"),

    /**
     * Open hi-hat (set 2).
     */
    HH_OPN2("Open hi-hat (set 2)"),

    /**
     * Pedal open hi-hat.
     */
    HH_PEDAL("Pedal hi-hat"),

    /**
     * Quarter open hi-hat.
     */
    HH_OTR("1/4 open hi-hat"),

    //
    // CYMBALS
    //

    /**
     * China cymbal.
     */
    CY_CHINA("China cymbal"),

    /**
     * Crash cymbal.
     */
    CY_CRASH("Crash cymbal"),

    /**
     * Ride cymbal cup.
     */
    CY_CUP("Ride cymbal cup"),

    /**
     * Ride cymbal 1.
     */
    CY_RIDE1("Ride cymbal 1"),

    /**
     * Ride cymbal 2.
     */
    CY_RIDE2("Ride cymbal 2"),

    //
    // TOMS
    //

    /**
     * Dry tom 1.
     */
    TM_DRY1("Dry tom 1"),

    /**
     * Dry tom 2.
     */
    TM_DRY2("Dry tom 2"),

    /**
     * Power tom 1.
     */
    TM_PWR1("Power tom 1"),

    /**
     * Power tom 2.
     */
    TM_PWR2("Power tom 2"),

    /**
     * Power tom 3.
     */
    TM_PWR3("Power tom 3"),

    /**
     * Room tom 1.
     */
    TM_ROOM1("Room tom 1"),

    /**
     * Room tom 2.
     */
    TM_ROOM2("Room tom 2"),

    /**
     * Techno tom.
     */
    TM_TEKNO("Techno tom"),

    //
    // PERCUSSION
    //

    /**
     * Agogo.
     */
    AGOGO("Agogo"),

    /**
     * Analogue clap.
     */
    ANLG_CLP("Analogue clap"),

    /**
     * Analogue cowbell.
     */
    ANLG_COW("Analogue cowbell"),

    /**
     * Bongo.
     */
    BONGO("Bongo"),

    /**
     * Cabasa.
     */
    CABASA("Cabasa"),

    /**
     * Claves.
     */
    CLAVES("Claves"),

    /**
     * High conga.
     */
    CONGA_HI("Conga high"),

    /**
     * Low conga.
     */
    CONGA_LO("Conga low"),

    /**
     * Muted conga.
     */
    CONGA_MU("Conga muted"),

    /**
     * Conga slap.
     */
    CONGA_SL("Conga slap"),

    /**
     * Conga heel.
     */
    CONGA_HL("Conga heel"),

    /**
     * Cowbell.
     */
    COWBELL("Cowbell"),

    /**
     * Guiro.
     */
    GUIRO("Guiro"),

    /**
     * Shaker.
     */
    SHAKER("Shaker"),

    /**
     * Tambourine.
     */
    TAMBRIN("Tambourine"),

    /**
     * High timbale.
     */
    TIMBAL_H("Timbale high"),

    /**
     * Low timbale.
     */
    TIMBAL_L("Timbale low"),

    /**
     * Triangle.
     */
    TRIANGL("Triangle"),

    /**
     * Whistle.
     */
    WHISTLE("Whistle"),

    /**
     * Wood block.
     */
    WOOD_BLK("Wood block"),

    //
    // SFX
    //

    /**
     * Ambient.
     */
    AMBIENT("Ambient"),

    /**
     * Kick drum attack.
     */
    BD_ATTACK("Kick attack"),

    /**
     * Kick drum body.
     */
    BD_BODY("Kick body"),

    /**
     * Bottle blow.
     */
    BOTTLE("Bottle blow"),

    /**
     * Finger snap.
     */
    FING_SNP("Finger snap"),

    /**
     * Noise.
     */
    NOISE("Noise"),

    /**
     * Rim transient 1.
     */
    RIM_TRN1("Rim transient 1"),

    /**
     * Rim transient 2.
     */
    RIM_TRN2("Rim transient 2"),

    /**
     * Scratch.
     */
    SCRATCH("Scratch"),

    /**
     * Tube hit.
     */
    TUBE("Tube hit"),

    /**
     * Stick.
     */
    STICK("Stick"),

    /**
     * Typist.
     */
    TYPIST("Typist"),

    //
    // WAVEFORMS
    //

    /**
     * The digital waveform.
     */
    DIG_WAVE("Digital wave"),

    /**
     * The 10% pulse wave.
     */
    P10_WAVE("10% pulse wave"),

    /**
     * The 25% pulse wave.
     */
    P25_WAVE("25% pulse wave"),

    /**
     * The 50% pulse wave.
     */
    P50_WAVE("50% pulse wave"),

    /**
     * The sawtooth wave.
     */
    SAW_WAVE("Sawtooth wave"),

    /**
     * The triangle wave.
     */
    TRI_WAVE("Triangle wave");

    /**
     * Get the number of enumeration values.
     *
     * @return the number of enumeration values
     */
    public static int size() {
        return values().length;
    }

    /**
     * The description of the enumeration value.
     */
    private final String description;

    /**
     * Construct an instance of an enumeration value.
     *
     * @param description the description of the enumeration value
     */
    Wave(final String description) {
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

package net.chriswareham.ry30;

/**
 * This enumeration describes the waves used by an element.
 *
 * <p>All waves apart from the last six can be reversed.</p>
 */
public enum Wave {

    // KICKS

    BD_ANLG("Analogue kick"),

    BD_DRYH("Dry kick (heavy)"),

    BD_DRYT1("Dry kick (tight 1)"),

    BD_DRYT2("Dry kick (tight 2)"),

    BD_GATE1("Gated kick 1"),

    BD_GATE2("Gated kick 2"),

    BD_PROC1("Processed kick 1"),

    BD_PROC2("Processed kick 2"),

    BD_PROC3("Processed kick 3"),

    BD_ROOM("Room kick"),

    BD_SFX("SFX kick"),

    BD_TEKNO("Techno kick"),

    // SNARES

    SD_ANLG1("Analogue snare 1"),

    SD_ANLG2("Analogue snare 2"),

    SD_DRYH("Dry snare (heavy)"),

    SD_DRYT1("Dry snare (tight 1)"),

    SD_DRYT2("Dry snare (tight 2)"),

    SD_DRYT3("Dry snare (tight 3)"),

    SD_GATE1("Gated snare 1"),

    SD_GATE2("Gated snare 2"),

    SD_GATE3("Gated snare 3"),

    SD_PROCS("Processed snare"),

    SD_REVRB("Reverb snare"),

    SD_RIM("Rim shot"),

    SD_ROOM1("Room snare 1"),

    SD_ROOM2("Room snare 2"),

    SD_ROOM3("Room snare 3"),

    SD_ROOM4("Room snare 4"),

    SD_ROOM5("Room snare 5"),

    SD_TEKNO("Techno snare"),

    // HIHATS

    HH_ANLG("Analogue hi-hat"),

    HH_CLS1A("Closed hi-hat (soft)"),

    HH_CLS1B("Closed hi-hat (hard)"),

    HH_CLS2("Closed hi-hat (set 2)"),

    HH_OPN1("Open hi-hat"),

    HH_OPN2("Open hi-hat (set 2)"),

    HH_PEDAL("Pedal hi-hat"),

    HH_OTR("1/4 open hi-hat"),

    // HIHATS

    CY_CHINA("China cymbal"),

    CY_CRASH("Crash cymbal"),

    CY_CUP("Ride cymbal cup"),

    CY_RIDE1("Ride cymbal 1"),

    CY_RIDE2("Ride cymbal 2"),

    // TOMS

    TM_DRY1("Dry tom 1"),

    TM_DRY2("Dry tom 2"),

    TM_PWR1("Power tom 1"),

    TM_PWR2("Power tom 2"),

    TM_PWR3("Power tom 3"),

    TM_ROOM1("Room tom 1"),

    TM_ROOM2("Room tom 2"),

    TM_TEKNO("Techno tom"),

    // PERCUSSION

    AGOGO("Agogo"),

    ANLG_CLP("Analogue clap"),

    ANLG_COW("Analogue cowbell"),

    BONGO("Bongo"),

    CABASA("Cabasa"),

    CLAVES("Claves"),

    CONGA_HI("Conga high"),

    CONGA_LO("Conga low"),

    CONGA_MU("Conga muted"),

    CONGA_SL("Conga slap"),

    CONGA_HL("Conga heel"),

    COWBELL("Cowbell"),

    GUIRO("Guiro"),

    SHAKER("Shaker"),

    TAMBRIN("Tambourine"),

    TIMBAL_H("Timbale high"),

    TIMBAL_L("Timbale low"),

    TRIANGL("Triangle"),

    WHISTLE("Whistle"),

    WOOD_BLK("Wood block"),

    // SFX

    AMBIENT("Ambient"),

    BD_ATTACK("Kick attack"),

    BD_BODY("Kick body"),

    BOTTLE("Bottle blow"),

    FING_SNP("Finger snap"),

    NOISE("Noise"),

    RIM_TRN1("Rim transient 1"),

    RIM_TRN2("Rim transient 2"),

    SCRATCH("Scratch"),

    TUBE("Tube hit"),

    STICK("Stick"),

    TYPIST("Typist"),

    // WAVEFORMS

    DIG_WAVE("Digital wave"),

    P10_WAVE("10% pulse wave"),

    P25_WAVE("25% pulse wave"),

    P50_WAVE("50% pulse wave"),

    SAW_WAVE("Sawtooth wave"),

    TRI_WAVE("Triangle wave");

    private final String description;

    Wave(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}

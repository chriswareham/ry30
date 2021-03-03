package net.chriswareham.ry30;

/**
 * This class describes a Yamaha RY30 element.
 */
public class Element {
    /**
     * The wave.
     */
    private Wave wave;

    /**
     * Whether the wave is reversed.
     */
    private boolean reverse;

    /**
     * The level (0 to 63).
     */
    private int level;

    /**
     * The pan (0 to 32, 16 is centre).
     */
    private int pan;

    /**
     * The pitch (-3600 to +3600).
     */
    private int pitch;

    /**
     * The decay (0 to 63).
     */
    private int decay;

    /**
     * The filter type.
     */
    private FilterType filterType;

    /**
     * The filter cutoff frequency (0 to 128 for LPF, 0 to 115 for HPF).
     */
    private int filterCutoff;

    /**
     * The filter resonance (0 to 99).
     */
    private int filterResonance;

    /**
     * The filter envelope generator level (-63 to +63)
     */
    private int filterEgLevel;

    /**
     * The filter envelope generator rate (0 to 63).
     */
    private int filterEgRate;

    /**
     * The level sensitivity (-7 to +7).
     */
    private int levelSensitivity;

    /**
     * The pitch sensitivity (-7 to +7).
     */
    private int pitchSensitivity;

    /**
     * The envelope generator sensitivity (-7 to +7).
     */
    private int egSensitivity;

    /**
     * The filter sensitivity (-7 to +7).
     */
    private int filterSensitivity;

    public void initialise() {
        wave = Wave.NOISE;
        reverse = false;
        level = 63;
        pan = 16;
        pitch = 0;
        decay = 55;
        filterType = FilterType.THRU;
        filterCutoff = 0;
        filterResonance = 0;
        filterEgLevel = 0;
        filterEgRate = 0;
        levelSensitivity = 4;
        pitchSensitivity = 0;
        egSensitivity = 0;
        filterSensitivity = 0;
    }

    public Wave getWave() {
        return wave;
    }

    public void setWave(final Wave wave) {
        this.wave = wave;
    }

    public boolean isReverse() {
        return reverse;
    }

    public void setReverse(final boolean reverse) {
        this.reverse = reverse;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(final int level) {
        this.level = level;
    }

    public int getPan() {
        return pan;
    }

    public void setPan(final int pan) {
        this.pan = pan;
    }

    public int getPitch() {
        return pitch;
    }

    public void setPitch(final int pitch) {
        this.pitch = pitch;
    }

    public int getDecay() {
        return decay;
    }

    public void setDecay(final int decay) {
        this.decay = decay;
    }

    public FilterType getFilterType() {
        return filterType;
    }

    public void setFilterType(final FilterType filterType) {
        this.filterType = filterType;
    }

    public int getFilterCutoff() {
        return filterCutoff;
    }

    public void setFilterCutoff(final int filterCutoff) {
        this.filterCutoff = filterCutoff;
    }

    public int getFilterResonance() {
        return filterResonance;
    }

    public void setFilterResonance(final int filterResonance) {
        this.filterResonance = filterResonance;
    }

    public int getFilterEgLevel() {
        return filterEgLevel;
    }

    public void setFilterEgLevel(final int filterEgLevel) {
        this.filterEgLevel = filterEgLevel;
    }

    public int getFilterEgRate() {
        return filterEgRate;
    }

    public void setFilterEgRate(final int filterEgRate) {
        this.filterEgRate = filterEgRate;
    }

    public int getLevelSensitivity() {
        return levelSensitivity;
    }

    public void setLevelSensitivity(final int levelSensitivity) {
        this.levelSensitivity = levelSensitivity;
    }

    public int getPitchSensitivity() {
        return pitchSensitivity;
    }

    public void setPitchSensitivity(final int pitchSensitivity) {
        this.pitchSensitivity = pitchSensitivity;
    }

    public int getEgSensitivity() {
        return egSensitivity;
    }

    public void setEgSensitivity(final int egSensitivity) {
        this.egSensitivity = egSensitivity;
    }

    public int getFilterSensitivity() {
        return filterSensitivity;
    }

    public void setFilterSensitivity(final int filterSensitivity) {
        this.filterSensitivity = filterSensitivity;
    }
}

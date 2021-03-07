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
     * The filter envelope generator level (-63 to +63).
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

    /**
     * Construct an instance that describes a Yamaha RY30 voice element.
     */
    public Element() {
        wave = Wave.NOISE;
    }

    /**
     * Initialise the element.
     */
    public void initialise() {
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

    /**
     * Get the wave.
     *
     * @return the wave
     */
    public Wave getWave() {
        return wave;
    }

    /**
     * Set the wave.
     *
     * @param wave the wave
     */
    public void setWave(final Wave wave) {
        this.wave = wave;
    }

    /**
     * Get whether the wave is reversed.
     *
     * @return whether the wave is reversed
     */
    public boolean isReverse() {
        return reverse;
    }

    /**
     * Set whether the wave is reversed.
     *
     * @param reverse whether the wave is reversed
     */
    public void setReverse(final boolean reverse) {
        this.reverse = reverse;
    }

    /**
     * Get the level (0 to 63).
     *
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Set the level (0 to 63).
     *
     * @param level the level
     */
    public void setLevel(final int level) {
        this.level = level;
    }

    /**
     * Get the pan (0 to 32, 16 is centre).
     *
     * @return the pan
     */
    public int getPan() {
        return pan;
    }

    /**
     * Set the pan (0 to 32, 16 is centre).
     *
     * @param pan the pan
     */
    public void setPan(final int pan) {
        this.pan = pan;
    }

    /**
     * Get the pitch (-3600 to +3600).
     *
     * @return the pitch
     */
    public int getPitch() {
        return pitch;
    }

    /**
     * Set the pitch (-3600 to +3600).
     *
     * @param pitch the pitch
     */
    public void setPitch(final int pitch) {
        this.pitch = pitch;
    }

    /**
     * Get the decay (0 to 63).
     *
     * @return the decay
     */
    public int getDecay() {
        return decay;
    }

    /**
     * Set the decay (0 to 63).
     *
     * @param decay the decay
     */
    public void setDecay(final int decay) {
        this.decay = decay;
    }

    /**
     * Get the filter type.
     *
     * @return the filter type
     */
    public FilterType getFilterType() {
        return filterType;
    }

    /**
     * Set the filter type.
     *
     * @param filterType the filter type
     */
    public void setFilterType(final FilterType filterType) {
        this.filterType = filterType;
    }

    /**
     * Get the filter cutoff frequency (0 to 128 for LPF, 0 to 115 for HPF).
     *
     * @return the filter cutoff frequency
     */
    public int getFilterCutoff() {
        return filterCutoff;
    }

    /**
     * Set the filter cutoff frequency (0 to 128 for LPF, 0 to 115 for HPF).
     *
     * @param filterCutoff the filter cutoff frequency
     */
    public void setFilterCutoff(final int filterCutoff) {
        this.filterCutoff = filterCutoff;
    }

    /**
     * Get the filter resonance (0 to 99).
     *
     * @return the filter resonance
     */
    public int getFilterResonance() {
        return filterResonance;
    }

    /**
     * Set the filter resonance (0 to 99).
     *
     * @param filterResonance the filter resonance
     */
    public void setFilterResonance(final int filterResonance) {
        this.filterResonance = filterResonance;
    }

    /**
     * Get the filter envelope generator level (-63 to +63).
     *
     * @return the filter envelope generator level
     */
    public int getFilterEgLevel() {
        return filterEgLevel;
    }

    /**
     * Set the filter envelope generator level (-63 to +63).
     *
     * @param filterEgLevel the filter envelope generator level
     */
    public void setFilterEgLevel(final int filterEgLevel) {
        this.filterEgLevel = filterEgLevel;
    }

    /**
     * Get the filter envelope generator rate (0 to 63).
     *
     * @return the filter envelope generator rate
     */
    public int getFilterEgRate() {
        return filterEgRate;
    }

    /**
     * Set the filter envelope generator rate (0 to 63).
     *
     * @param filterEgRate the filter envelope generator rate
     */
    public void setFilterEgRate(final int filterEgRate) {
        this.filterEgRate = filterEgRate;
    }

    /**
     * Get the level sensitivity (-7 to +7).
     *
     * @return the level sensitivity
     */
    public int getLevelSensitivity() {
        return levelSensitivity;
    }

    /**
     * Set the level sensitivity (-7 to +7).
     *
     * @param levelSensitivity the level sensitivity
     */
    public void setLevelSensitivity(final int levelSensitivity) {
        this.levelSensitivity = levelSensitivity;
    }

    /**
     * Get the pitch sensitivity (-7 to +7).
     *
     * @return the pitch sensitivity
     */
    public int getPitchSensitivity() {
        return pitchSensitivity;
    }

    /**
     * Set the pitch sensitivity (-7 to +7).
     *
     * @param pitchSensitivity the pitch sensitivity
     */
    public void setPitchSensitivity(final int pitchSensitivity) {
        this.pitchSensitivity = pitchSensitivity;
    }

    /**
     * Get the envelope generator sensitivity (-7 to +7).
     *
     * @return the envelope generator sensitivity
     */
    public int getEgSensitivity() {
        return egSensitivity;
    }

    /**
     * Set the envelope generator sensitivity (-7 to +7).
     *
     * @param egSensitivity the envelope generator sensitivity
     */
    public void setEgSensitivity(final int egSensitivity) {
        this.egSensitivity = egSensitivity;
    }

    /**
     * Get the filter sensitivity (-7 to +7).
     *
     * @return the filter sensitivity
     */
    public int getFilterSensitivity() {
        return filterSensitivity;
    }

    /**
     * Set the filter sensitivity (-7 to +7).
     *
     * @param filterSensitivity the filter sensitivity
     */
    public void setFilterSensitivity(final int filterSensitivity) {
        this.filterSensitivity = filterSensitivity;
    }
}

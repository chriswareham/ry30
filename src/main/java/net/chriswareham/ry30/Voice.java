package net.chriswareham.ry30;

/**
 * This class describes a Yamaha RY30 voice.
 */
public class Voice {
    /**
     * The voice name (8 ASCII characters).
     */
    private String name;

    /**
     * The voice level (0 to 63).
     */
    private int level;

    /**
     * The pitch envelope generator level (-72 to +72).
     */
    private int pitchEgLevel;

    /**
     * The pitch envelope generator rate (0 to 63).
     */
    private int pitchEgRate;

    /**
     * Whether the voice is polyphonic.
     */
    private boolean poly;

    /**
     * The alternate group the voice is assigned to.
     */
    private AlternateGroup alternateGroup;

    /**
     * The output the voice is assigned to.
     */
    private OutputAssign outputAssign;

    /**
     * The voice individual output level (0 to 63).
     */
    private int individualOutputLevel;

    /**
     * The first element of the voice.
     */
    private final Element element1 = new Element();

    /**
     * The first element of the voice.
     */
    private final Element element2 = new Element();

    public void initialise() {
        name = "";
        level = 63;
        pitchEgLevel = 0;
        pitchEgRate = 0;
        poly = false;
        alternateGroup = AlternateGroup.OFF;
        outputAssign = OutputAssign.STEREO;
        individualOutputLevel = 63;
        element1.initialise();
        element2.initialise();
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(final int level) {
        this.level = level;
    }

    public int getPitchEgLevel() {
        return pitchEgLevel;
    }

    public void setPitchEgLevel(final int pitchEgLevel) {
        this.pitchEgLevel = pitchEgLevel;
    }

    public int getPitchEgRate() {
        return pitchEgRate;
    }

    public void setPitchEgRate(int pitchEgRate) {
        this.pitchEgRate = pitchEgRate;
    }

    public boolean isPoly() {
        return poly;
    }

    public void setPoly(final boolean poly) {
        this.poly = poly;
    }

    public AlternateGroup getAlternateGroup() {
        return alternateGroup;
    }

    public void setAlternateGroup(final AlternateGroup alternateGroup) {
        this.alternateGroup = alternateGroup;
    }

    public OutputAssign getOutputAssign() {
        return outputAssign;
    }

    public void setOutputAssign(final OutputAssign outputAssign) {
        this.outputAssign = outputAssign;
    }

    public int getIndividualOutputLevel() {
        return individualOutputLevel;
    }

    public void setIndividualOutputLevel(final int individualOutputLevel) {
        this.individualOutputLevel = individualOutputLevel;
    }

    public Element getElement1() {
        return element1;
    }

    public Element getElement2() {
        return element2;
    }
}

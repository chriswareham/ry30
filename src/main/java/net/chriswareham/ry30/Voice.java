package net.chriswareham.ry30;

import net.chriswareham.midi.SysExSerialisable;

/**
 * This class describes a Yamaha RY30 voice.
 */
public class Voice implements SysExSerialisable {
    /**
     * The voice dump header.
     */
    private static final int[] VOICE_DUMP_HEADER = { 0xF0, 0x43, 0x00, 0x7A, 0x00, 0x76 };

    /**
     * The voice dump ID.
     */
    private static final int[] VOICE_DUMP_ID = { 'L', 'M', ' ', ' ', '0', '0', '1', '7', ' ', ' ', 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };

    /**
     * The voice dump footer.
     */
    private static final int VOICE_DUMP_FOOTER = 0xF7;

    /**
     * The buffer to encode a voice dump into.
     */
    private final int[] buffer = new int[126];

    /**
     * The source voice number.
     */
    private int source;

    /**
     * The destination voice number.
     */
    private int destination;

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

    public Voice() {
        System.arraycopy(VOICE_DUMP_HEADER, 0, buffer, 0, VOICE_DUMP_HEADER.length);
        System.arraycopy(VOICE_DUMP_ID, 0, buffer, VOICE_DUMP_HEADER.length, VOICE_DUMP_ID.length);
        buffer[125] = VOICE_DUMP_FOOTER;
    }

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

    public int getSource() {
        return source;
    }

    public void setSource(final int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(final int destination) {
        this.destination = destination;
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

    @Override
    public int[] sysExSerialise() {
        buffer[30] = source;
        buffer[31] = destination;

        // Common

        VoiceUtils.encode(buffer, 32, level);
        VoiceUtils.encode(buffer, 34, pitchEgLevel);
        VoiceUtils.encode(buffer, 36, pitchEgRate);
        VoiceUtils.encode(buffer, 38, combineOutputAssignAlternateGroupPoly());
        VoiceUtils.encode(buffer, 40, individualOutputLevel);

        // Name

        VoiceUtils.encode(buffer, 58, 0xFF);
        VoiceUtils.encode(buffer, 60, 0xFF);
        VoiceUtils.encode(buffer, 62, 0xFF);

        // Element 1

        VoiceUtils.encode(buffer, 64, element1.isReverse() ? element1.getWave().ordinal() + Wave.size() : element1.getWave().ordinal());
        VoiceUtils.encode(buffer, 66, element1.getLevel());
        VoiceUtils.encode(buffer, 68, element1.getPan());
        VoiceUtils.encode(buffer, 70, element1.getPitch() / 100);
        VoiceUtils.encode(buffer, 72, element1.getPitch() % 100);
        VoiceUtils.encode(buffer, 74, element1.getDecay());
        VoiceUtils.encode(buffer, 76, element1.getFilterType().ordinal());
        VoiceUtils.encode(buffer, 78, element1.getFilterCutoff());
        VoiceUtils.encode(buffer, 80, element1.getFilterResonance());
        VoiceUtils.encode(buffer, 82, element1.getFilterEgLevel());
        VoiceUtils.encode(buffer, 84, element1.getFilterEgRate());
        VoiceUtils.encode(buffer, 86, element1.getLevelSensitivity());
        VoiceUtils.encode(buffer, 88, element1.getPitchSensitivity());
        VoiceUtils.encode(buffer, 90, element1.getEgSensitivity());
        VoiceUtils.encode(buffer, 92, element1.getFilterSensitivity());

        // Element 2

        VoiceUtils.encode(buffer, 94, element2.isReverse() ? element2.getWave().ordinal() + Wave.size() : element2.getWave().ordinal());
        VoiceUtils.encode(buffer, 96, element2.getLevel());
        VoiceUtils.encode(buffer, 98, element2.getPan());
        VoiceUtils.encode(buffer, 100, element2.getPitch() / 100);
        VoiceUtils.encode(buffer, 102, element2.getPitch() % 100);
        VoiceUtils.encode(buffer, 104, element2.getDecay());
        VoiceUtils.encode(buffer, 106, element2.getFilterType().ordinal());
        VoiceUtils.encode(buffer, 108, element2.getFilterCutoff());
        VoiceUtils.encode(buffer, 110, element2.getFilterResonance());
        VoiceUtils.encode(buffer, 112, element2.getFilterEgLevel());
        VoiceUtils.encode(buffer, 114, element2.getFilterEgRate());
        VoiceUtils.encode(buffer, 116, element2.getLevelSensitivity());
        VoiceUtils.encode(buffer, 118, element2.getPitchSensitivity());
        VoiceUtils.encode(buffer, 120, element2.getEgSensitivity());
        VoiceUtils.encode(buffer, 122, element2.getFilterSensitivity());

        buffer[124] = VoiceUtils.checksum(buffer, 6, 123);

        return buffer;
    }

    private int combineOutputAssignAlternateGroupPoly() {
        int value = outputAssign.ordinal() + (alternateGroup.ordinal() * 10);

        if (poly) {
            value += 0x80;
        }

        return value;
    }
}

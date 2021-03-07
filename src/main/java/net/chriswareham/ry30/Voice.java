package net.chriswareham.ry30;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.SysexMessage;

import net.chriswareham.midi.MidiUtils;

/**
 * This class describes a Yamaha RY30 voice.
 */
public class Voice {
    /**
     * The voice dump header.
     */
    private static final byte[] VOICE_DUMP_HEADER = {0x43, 0x00, 0x7A, 0x00, 0x76};

    /**
     * The voice dump ID.
     */
    private static final byte[] VOICE_DUMP_ID = {'L', 'M', ' ', ' ', '0', '0', '1', '7', ' ', ' ', 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};

    /**
     * The buffer to encode a System Exclusive voice dump into.
     */
    private final byte[] buffer = new byte[126];

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
     * The alternate group for the voice.
     */
    private AlternateGroup alternateGroup;

    /**
     * The output assignment for the voice.
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
     * The second element of the voice.
     */
    private final Element element2 = new Element();

    /**
     * Construct an instance that describes a Yamaha RY30 voice.
     */
    public Voice() {
        name = "";
        buffer[0] = MidiUtils.SYSEX_INITIAL_BYTE;
        System.arraycopy(VOICE_DUMP_HEADER, 0, buffer, 1, VOICE_DUMP_HEADER.length);
        System.arraycopy(VOICE_DUMP_ID, 0, buffer, VOICE_DUMP_HEADER.length + 1, VOICE_DUMP_ID.length);
        buffer[125] = MidiUtils.SYSEX_TERMINATING_BYTE;
    }

    /**
     * Initialise the voice.
     */
    public void initialise() {
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

    /**
     * Get the source voice number.
     *
     * @return the source voice number
     */
    public int getSource() {
        return source;
    }

    /**
     * Set the source voice number.
     *
     * @param source the source voice number
     */
    public void setSource(final int source) {
        this.source = source;
    }

    /**
     * Get the destination voice number.
     *
     * @return the destination voice number
     */
    public int getDestination() {
        return destination;
    }

    /**
     * Set the destination voice number.
     *
     * @param destination the destination voice number
     */
    public void setDestination(final int destination) {
        this.destination = destination;
    }

    /**
     * Get the voice name (8 ASCII characters).
     *
     * @return the voice name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the voice name (8 ASCII characters).
     *
     * @param name the voice name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Get the voice level (0 to 63).
     *
     * @return the voice level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Set the voice level (0 to 63).
     *
     * @param level the voice level
     */
    public void setLevel(final int level) {
        this.level = level;
    }

    /**
     * Get the pitch envelope generator level (-72 to +72).
     *
     * @return the pitch envelope generator level
     */
    public int getPitchEgLevel() {
        return pitchEgLevel;
    }

    /**
     * Set the pitch envelope generator level (-72 to +72).
     *
     * @param pitchEgLevel the pitch envelope generator level
     */
    public void setPitchEgLevel(final int pitchEgLevel) {
        this.pitchEgLevel = pitchEgLevel;
    }

    /**
     * Get the pitch envelope generator rate (0 to 63).
     *
     * @return the pitch envelope generator rate
     */
    public int getPitchEgRate() {
        return pitchEgRate;
    }

    /**
     * Set the pitch envelope generator rate (0 to 63).
     *
     * @param pitchEgRate the pitch envelope generator rate
     */
    public void setPitchEgRate(final int pitchEgRate) {
        this.pitchEgRate = pitchEgRate;
    }

    /**
     * Get whether the voice is polyphonic.
     *
     * @return whether the voice is polyphonic
     */
    public boolean isPoly() {
        return poly;
    }

    /**
     * Set whether the voice is polyphonic.
     *
     * @param poly whether the voice is polyphonic
     */
    public void setPoly(final boolean poly) {
        this.poly = poly;
    }

    /**
     * Get the alternate group for the voice.
     *
     * @return the alternate group for the voice
     */
    public AlternateGroup getAlternateGroup() {
        return alternateGroup;
    }

    /**
     * Set the alternate group for the voice.
     *
     * @param alternateGroup the alternate group for the voice
     */
    public void setAlternateGroup(final AlternateGroup alternateGroup) {
        this.alternateGroup = alternateGroup;
    }

    /**
     * Get the output assignment for the voice.
     *
     * @return the output assignment for the voice
     */
    public OutputAssign getOutputAssign() {
        return outputAssign;
    }

    /**
     * Set the output assignment for the voice.
     *
     * @param outputAssign the output assignment for the voice
     */
    public void setOutputAssign(final OutputAssign outputAssign) {
        this.outputAssign = outputAssign;
    }

    /**
     * Get the voice individual output level (0 to 63).
     *
     * @return the voice individual output level
     */
    public int getIndividualOutputLevel() {
        return individualOutputLevel;
    }

    /**
     * Set the voice individual output level (0 to 63).
     *
     * @param individualOutputLevel the voice individual output level
     */
    public void setIndividualOutputLevel(final int individualOutputLevel) {
        this.individualOutputLevel = individualOutputLevel;
    }

    /**
     * Get the first element of the voice.
     *
     * @return the first element of the voice
     */
    public Element getElement1() {
        return element1;
    }

    /**
     * Get the second element of the voice.
     *
     * @return the second element of the voice
     */
    public Element getElement2() {
        return element2;
    }

    /**
     * Serialise the voice as a System Exclusive voice dump.
     *
     * @return a System Exclusive voice dump
     * @throws InvalidMidiDataException if the voice data is invalid
     */
    public SysexMessage serialise() throws InvalidMidiDataException {
        buffer[30] = (byte) source;
        buffer[31] = (byte) destination;

        // Common

        VoiceUtils.encode(buffer, 32, level);
        VoiceUtils.encode(buffer, 34, pitchEgLevel + 72);
        VoiceUtils.encode(buffer, 36, pitchEgRate);
        VoiceUtils.encode(buffer, 38, combineOutputAssignAlternateGroupPoly());
        VoiceUtils.encode(buffer, 40, individualOutputLevel);

        // Name

        for (int i = 0; i < name.length(); ++i) {
            VoiceUtils.encode(buffer, 42 + (i * 2), name.charAt(i));
        }
        for (int i = name.length(); i < 8; ++i) {
            VoiceUtils.encode(buffer, 42 + (i * 2), ' ');
        }

        VoiceUtils.encode(buffer, 58, 0xFF);
        VoiceUtils.encode(buffer, 60, 0xFF);
        VoiceUtils.encode(buffer, 62, 0xFF);

        // Element 1

        VoiceUtils.encode(buffer, 64, element1.isReverse() ? element1.getWave().ordinal() + Wave.size() : element1.getWave().ordinal());
        VoiceUtils.encode(buffer, 66, element1.getLevel());
        VoiceUtils.encode(buffer, 68, element1.getPan());
        VoiceUtils.encode(buffer, 70, element1.getPitch() / 100 + 36);
        VoiceUtils.encode(buffer, 72, element1.getPitch() % 100);
        VoiceUtils.encode(buffer, 74, element1.getDecay());
        VoiceUtils.encode(buffer, 76, element1.getFilterType().ordinal());
        VoiceUtils.encode(buffer, 78, element1.getFilterCutoff());
        VoiceUtils.encode(buffer, 80, element1.getFilterResonance());
        VoiceUtils.encode(buffer, 82, element1.getFilterEgLevel() + 63);
        VoiceUtils.encode(buffer, 84, element1.getFilterEgRate());
        VoiceUtils.encode(buffer, 86, element1.getLevelSensitivity() < 0 ? Math.abs(element1.getLevelSensitivity()) + 8 : element1.getLevelSensitivity());
        VoiceUtils.encode(buffer, 88, element1.getPitchSensitivity() < 0 ? Math.abs(element1.getPitchSensitivity()) + 8 : element1.getPitchSensitivity());
        VoiceUtils.encode(buffer, 90, element1.getEgSensitivity() < 0 ? Math.abs(element1.getEgSensitivity()) + 8 : element1.getEgSensitivity());
        VoiceUtils.encode(buffer, 92, element1.getFilterSensitivity() < 0 ? Math.abs(element1.getFilterSensitivity()) + 8 : element1.getFilterSensitivity());

        // Element 2

        VoiceUtils.encode(buffer, 94, element2.isReverse() ? element2.getWave().ordinal() + Wave.size() : element2.getWave().ordinal());
        VoiceUtils.encode(buffer, 96, element2.getLevel());
        VoiceUtils.encode(buffer, 98, element2.getPan());
        VoiceUtils.encode(buffer, 100, element2.getPitch() / 100 + 36);
        VoiceUtils.encode(buffer, 102, element2.getPitch() % 100);
        VoiceUtils.encode(buffer, 104, element2.getDecay());
        VoiceUtils.encode(buffer, 106, element2.getFilterType().ordinal());
        VoiceUtils.encode(buffer, 108, element2.getFilterCutoff());
        VoiceUtils.encode(buffer, 110, element2.getFilterResonance());
        VoiceUtils.encode(buffer, 112, element2.getFilterEgLevel() + 63);
        VoiceUtils.encode(buffer, 114, element2.getFilterEgRate());
        VoiceUtils.encode(buffer, 116, element2.getLevelSensitivity() < 0 ? Math.abs(element2.getLevelSensitivity()) + 8 : element2.getLevelSensitivity());
        VoiceUtils.encode(buffer, 118, element2.getPitchSensitivity() < 0 ? Math.abs(element2.getPitchSensitivity()) + 8 : element2.getPitchSensitivity());
        VoiceUtils.encode(buffer, 120, element2.getEgSensitivity() < 0 ? Math.abs(element2.getEgSensitivity()) + 8 : element2.getEgSensitivity());
        VoiceUtils.encode(buffer, 122, element2.getFilterSensitivity() < 0 ? Math.abs(element2.getFilterSensitivity()) + 8 : element2.getFilterSensitivity());

        buffer[124] = VoiceUtils.checksum(buffer, 6, 123);

        return new SysexMessage(buffer, buffer.length);
    }

    /**
     * Combine the output assignment, alternate group and whether the voice is
     * polyphonic into an 8 bit value.
     *
     * @return the 8 bit value
     */
    private int combineOutputAssignAlternateGroupPoly() {
        int value = outputAssign.ordinal();

        value |= alternateGroup.ordinal() << 4;

        if (poly) {
            value |= 0x80;
        }

        return value;
    }
}

package net.chriswareham.midi;

/**
 * This interface is implemented by classes that want to serialise their data as
 * the content of a SysEx message.
 */
public interface SysExSerialisable {
    /**
     * Serialise data as the content of a SysEx message.
     *
     * @return the data serialised as the content of a SysEx message
     */
    int[] sysExSerialise();
}

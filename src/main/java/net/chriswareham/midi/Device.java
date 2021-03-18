package net.chriswareham.midi;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Transmitter;

/**
 * This class describes a device that can be used to receive or transmit MIDI
 * data.
 */
public class Device implements AutoCloseable {
    /**
     * The MIDI device.
     */
    private final MidiDevice device;

    /**
     * Construct an instance of a device that can be used to receive or transmit
     * MIDI data.
     *
     * @param device the MIDI device
     */
    public Device(final MidiDevice device) {
        this.device = device;
    }

    /**
     * Get whether the device is open.
     *
     * @return whether the device is open
     */
    public boolean isOpen() {
        return device != null && device.isOpen();
    }

    /**
     * Open the device.
     *
     * @throws MidiUnavailableException if the device cannot be opened
     */
    public void open() throws MidiUnavailableException {
        if (device != null) {
            device.open();
        }
    }

    /**
     * Close the device.
     */
    @Override
    public void close() {
        if (device != null) {
            device.close();
        }
    }

    /**
     * Obtain a receiver through which the device can receive MIDI data.
     *
     * @return a receiver through which the device can receive MIDI data
     * @throws MidiUnavailableException if a receiver cannot be obtained
     */
    public Receiver getReceiver() throws MidiUnavailableException {
        return device != null ? device.getReceiver() : null;
    }

    /**
     * Obtain a transmitter through which the device can transmit MIDI data.
     *
     * @return a transmitter through which the device can transmit MIDI data
     * @throws MidiUnavailableException if a transmitter cannot be obtained
     */
    public Transmitter getTransmitter() throws MidiUnavailableException {
        return device != null ? device.getTransmitter() : null;
    }

    /**
     * Get a string identifying the device.
     *
     * @return a string identifying the device
     */
    @Override
    public String toString() {
        return device != null ? device.getDeviceInfo().getName() : "None";
    }

    /**
     * Get whether an object is equal to the device.
     *
     * @param that the object
     * @return whether the object is equal to the device
     */
    @Override
    public boolean equals(final Object that) {
        if (this == that) {
            return true;
        }
        if (!(that instanceof Device)) {
            return false;
        }
        return toString().equals(that.toString());
    }

    /**
     * Get a hash code for the device.
     *
     * @return the hash code for the device
     */
    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}

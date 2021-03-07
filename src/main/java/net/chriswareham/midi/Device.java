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
        return device.isOpen();
    }

    /**
     * Open the device.
     *
     * @throws MidiUnavailableException if the device cannot be opened
     */
    public void open() throws MidiUnavailableException {
        device.open();
    }

    /**
     * Close the device.
     */
    @Override
    public void close() {
        device.close();
    }

    /**
     * Obtain a receiver through which the device can receive MIDI data.
     *
     * @return a receiver through which the device can receive MIDI data
     * @throws MidiUnavailableException if a receiver cannot be obtained
     */
    public Receiver getReceiver() throws MidiUnavailableException {
        return device.getReceiver();
    }

    /**
     * Obtain a transmitter through which the device can transmit MIDI data.
     *
     * @return a transmitter through which the device can transmit MIDI data
     * @throws MidiUnavailableException if a transmitter cannot be obtained
     */
    public Transmitter getTransmitter() throws MidiUnavailableException {
        return device.getTransmitter();
    }

    /**
     * Get a string identifying the device.
     *
     * @return a string identifying the device
     */
    @Override
    public String toString() {
        return device.getDeviceInfo().getName();
    }
}

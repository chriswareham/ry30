package net.chriswareham.midi;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Transmitter;

public class Device {

    private final MidiDevice device;

    public Device(final MidiDevice device) {
        this.device = device;
    }

    public boolean isOpen() {
        return device.isOpen();
    }

    public void open() throws MidiUnavailableException {
        device.open();
    }

    public void close() {
        device.close();
    }

    public Receiver getReceiver() throws MidiUnavailableException {
        return device.getReceiver();
    }

    public Transmitter getTransmitter() throws MidiUnavailableException {
        return device.getTransmitter();
    }

    @Override
    public String toString() {
        return device.getDeviceInfo().getName();
    }
}

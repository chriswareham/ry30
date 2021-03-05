package net.chriswareham.midi;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiUnavailableException;

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

    @Override
    public String toString() {
        return device.getDeviceInfo().getName();
    }
}

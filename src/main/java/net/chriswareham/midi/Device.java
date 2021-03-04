package net.chriswareham.midi;

import javax.sound.midi.MidiDevice;

public class Device{

    private final MidiDevice device;

    public Device(final MidiDevice device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return device.getDeviceInfo().getName();
    }
}

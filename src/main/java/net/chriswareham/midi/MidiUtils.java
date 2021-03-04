package net.chriswareham.midi;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;

/**
 * This class provides utility methods for the Java MIDI API.
 */
public final class MidiUtils {
    /**
     * The default velocity.
     */
    public static final int DEFAULT_VELOCITY = 64;

    /**
     * Get the MIDI devices that can be used to receive data.
     *
     * @return the MIDI devices that can be used to receive data
     */
    public static List<Device> getInputDevices() {
        MidiDevice.Info[] deviceInfos = MidiSystem.getMidiDeviceInfo();

        if (deviceInfos.length == 0) {
            return List.of();
        }

        List<Device> devices = new ArrayList<>();

        for (MidiDevice.Info deviceInfo : deviceInfos) {
            try {
                MidiDevice device = MidiSystem.getMidiDevice(deviceInfo);
                if (device.getMaxReceivers() != 0) {
                    devices.add(new Device(device));
                }
            } catch (MidiUnavailableException exception) {
                // ignored
            }
        }

        return devices;
    }

    /**
     * Get the MIDI devices that can be used to transmit data.
     *
     * @return the MIDI devices that can be used to transmit data
     */
    public static List<Device> getOutputDevices() {
        MidiDevice.Info[] deviceInfos = MidiSystem.getMidiDeviceInfo();

        if (deviceInfos.length == 0) {
            return List.of();
        }

        List<Device> devices = new ArrayList<>();

        for (MidiDevice.Info deviceInfo : deviceInfos) {
            try {
                MidiDevice device = MidiSystem.getMidiDevice(deviceInfo);
                if (device.getMaxTransmitters() != 0) {
                    devices.add(new Device(device));
                }
            } catch (MidiUnavailableException exception) {
                // ignored
            }
        }

        return devices;
    }

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private MidiUtils() {
        super();
    }
}

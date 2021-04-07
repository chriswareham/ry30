package net.chriswareham.midi;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Synthesizer;

/**
 * This class provides utility methods for the Java MIDI API.
 */
public final class MidiUtils {
    /**
     * The initial byte of a System Exclusive message.
     */
    public static final byte SYSEX_INITIAL_BYTE = (byte) 0xF0;

    /**
     * The terminating byte of a System Exclusive message.
     */
    public static final byte SYSEX_TERMINATING_BYTE = (byte) 0xF7;

    /**
     * Get the devices that can be used to receive MIDI data.
     *
     * @return the devices that can be used to receive MIDI data
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
                if (isInputDevice(device)) {
                    devices.add(new Device(device));
                }
            } catch (MidiUnavailableException exception) {
                // ignored
            }
        }

        return devices;
    }

    /**
     * Get the devices that can be used to transmit MIDI data.
     *
     * @return the devices that can be used to transmit MIDI data
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
                if (isOutputDevice(device)) {
                    devices.add(new Device(device));
                }
            } catch (MidiUnavailableException exception) {
                // ignored
            }
        }

        return devices;
    }

    /**
     * Get whether a device is a hardware MIDI input.
     *
     * @param device the device
     * @return whether the device id a hardware MIDI input
     */
    public static boolean isInputDevice(final MidiDevice device) {
        return device != null
            && !(device instanceof Sequencer)
            && !(device instanceof Synthesizer)
            && device.getMaxTransmitters() != 0;
    }

    /**
     * Get whether a device is a hardware MIDI output.
     *
     * @param device the device
     * @return whether the device id a hardware MIDI output
     */
    public static boolean isOutputDevice(final MidiDevice device) {
        return device != null
            && !(device instanceof Sequencer)
            && !(device instanceof Synthesizer)
            && device.getMaxReceivers() != 0;
    }

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private MidiUtils() {
        super();
    }
}

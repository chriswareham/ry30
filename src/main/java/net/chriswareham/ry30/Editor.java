package net.chriswareham.ry30;

import java.awt.BorderLayout;

import javax.sound.midi.Receiver;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

import net.chriswareham.gui.AbstractFrame;
import net.chriswareham.gui.MenuUtils;
import net.chriswareham.gui.StatusBar;
import net.chriswareham.midi.Device;

/**
 * This class provides an editor frame for a Yamaha RY30 voice.
 */
public class Editor extends AbstractFrame {
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The format string for the status bar.
     */
    private static final String STATUS_BAR_FORMAT = "Input device: %s Output device: %s";

    /**
     * Main entry point for running the editor.
     *
     * @param args the command line arguments
     */
    public static void main(final String... args) {
        new Editor().open();
    }

    /**
     * The current input device.
     */
    private Device inputDevice;

    /**
     * The current output device.
     */
    private Device outputDevice;

    /**
     * The current voice.
     */
    private final Voice voice = new Voice();

    /**
     * The send voice menu item.
     */
    private final JMenuItem sendVoiceMenuItem = MenuUtils.createMenuItem("Send Voice", "S", "Send voice", event -> sendVoice(), false);

    /**
     * The panel for editing the common values of a voice.
     */
    private final CommonPanel commonPanel = new CommonPanel(this::voiceUpdated);

    /**
     * The panel for editing the first element of a voice.
     */
    private final ElementPanel element1Panel = new ElementPanel(this::voiceUpdated);

    /**
     * The panel for editing the second element of a voice.
     */
    private final ElementPanel element2Panel = new ElementPanel(this::voiceUpdated);

    /**
     * The status bar.
     */
    private final StatusBar statusBar = new StatusBar(String.format(STATUS_BAR_FORMAT, "-", "-"));

    /**
     * Construct an instance of an editor frame for a Yamaha RY30 voice.
     */
    public Editor() {
        super("Yamaha RY30 Editor");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void createInterface() {
        addWindowClosedListener(event -> System.exit(0));

        setJMenuBar(createMenuBar());

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Common", commonPanel);
        tabbedPane.addTab("Element 1", element1Panel);
        tabbedPane.addTab("Element 2", element2Panel);

        getContentPane().add(tabbedPane, BorderLayout.CENTER);

        getContentPane().add(statusBar, BorderLayout.SOUTH);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void populateInterface() {
        initialiseVoice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void interfaceClosed() {
        closeInputDevice();
        closeOutputDevice();
    }

    /**
     * Create the menu bar.
     *
     * @return the menu bar
     */
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = menuBar.add(MenuUtils.createMenu("File", "F", "File"));

        menu.add(MenuUtils.createMenuItem("Device", "D", "Device", event -> device()));

        menu.addSeparator();

        menu.add(MenuUtils.createMenuItem("Exit", "X", "Exit", event -> close()));

        menu = menuBar.add(MenuUtils.createMenu("Edit", "E", "Edit"));

        menu.add(MenuUtils.createMenuItem("Intitialise Voice", "I", "Initialise voice", event -> initialiseVoice()));

        menu.add(sendVoiceMenuItem);

        return menuBar;
    }

    /**
     * Show the device dialog.
     */
    private void device() {
        new DeviceDialog(this)
            .addInputDeviceChangedListener(device -> inputDeviceChanged(device))
            .addOutputDeviceChangedListener(device -> outputDeviceChanged(device))
            .open();
    }

    /**
     * Handle the selection of an input device.
     *
     * @param device the selected input device
     */
    private void inputDeviceChanged(final Device device) {
        closeInputDevice();
        openInputDevice(device);
    }

    /**
     * Handle the selection of an output device.
     *
     * @param device the selected output device
     */
    private void outputDeviceChanged(final Device device) {
        closeOutputDevice();
        openOutputDevice(device);
    }

    /**
     * Open an input device.
     *
     * @param device the input device to open
     */
    private void openInputDevice(final Device device) {
        call(() -> {
            if (!device.isOpen()) {
                device.open();
            }
            inputDevice = device;
            updateStatusBar();
        });
    }

    /**
     * Close the current input device.
     */
    private void closeInputDevice() {
        if (inputDevice != null) {
            if (inputDevice.isOpen()) {
                inputDevice.close();
            }
            inputDevice = null;
            updateStatusBar();
        }
    }

    /**
     * Open an output device.
     *
     * @param device the output device to open
     */
    private void openOutputDevice(final Device device) {
        call(() -> {
            if (!device.isOpen()) {
                device.open();
            }
            outputDevice = device;
            sendVoiceMenuItem.setEnabled(true);
            updateStatusBar();
        });
    }

    /**
     * Close the current output device.
     */
    private void closeOutputDevice() {
        if (outputDevice != null) {
            if (outputDevice.isOpen()) {
                outputDevice.close();
            }
            outputDevice = null;
            sendVoiceMenuItem.setEnabled(false);
            updateStatusBar();
        }
    }

    /**
     * Initialise the current voice.
     */
    private void initialiseVoice() {
        voice.initialise();

        commonPanel.setVoice(voice);
        element1Panel.setElement(voice.getElement1());
        element2Panel.setElement(voice.getElement2());
    }

    /**
     * Send the current voice via the current output device.
     */
    private void sendVoice() {
        if (outputDevice != null) {
            call(() -> {
                try (Receiver receiver = outputDevice.getReceiver()) {
                    receiver.send(voice.serialise(), -1);
                }
            });
        }
    }

    /**
     * Update the status bar.
     */
    private void updateStatusBar() {
        statusBar.setText(String.format(STATUS_BAR_FORMAT, inputDevice != null ? inputDevice : "-", outputDevice != null ? outputDevice : "-"));
    }

    /**
     * Notified when a voice has been updated.
     */
    private void voiceUpdated() {
        sendVoice();
    }
}

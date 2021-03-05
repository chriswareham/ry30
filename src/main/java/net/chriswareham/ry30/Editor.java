package net.chriswareham.ry30;

import java.awt.BorderLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;

import net.chriswareham.gui.AbstractFrame;
import net.chriswareham.gui.MenuUtils;
import net.chriswareham.gui.StatusBar;
import net.chriswareham.midi.Device;

public class Editor extends AbstractFrame {

    private static final long serialVersionUID = 1L;

    private static final String STATUS_BAR_FORMAT = "Input device: %s Output device: %s";

    public static void main(final String... args) {
        new Editor().open();
    }

    private Device inputDevice;

    private Device outputDevice;

    private Voice voice = new Voice();

    private final CommonPanel commonPanel = new CommonPanel();

    private final ElementPanel element1Panel = new ElementPanel();

    private final ElementPanel element2Panel = new ElementPanel();

    private final StatusBar statusBar = new StatusBar(String.format(STATUS_BAR_FORMAT, "-", "-"));

    public Editor() {
        super("Yamaha RY30 Editor");
    }

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

    @Override
    protected void populateInterface() {
        voice.initialise();

        commonPanel.setVoice(voice);
        element1Panel.setElement(voice.getElement1());
        element2Panel.setElement(voice.getElement2());
    }

    @Override
    protected void interfaceClosed() {
        closeInputDevice();
        closeOutputDevice();
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = menuBar.add(MenuUtils.createMenu("File", "F", "File"));

        menu.add(MenuUtils.createMenuItem("Device", "D", "Device", event -> device()));

        menu.addSeparator();

        menu.add(MenuUtils.createMenuItem("Exit", "X", "Exit", event -> close()));

        return menuBar;
    }

    private void device() {
        new DeviceDialog(this)
            .addInputDeviceChangedListener(device -> inputDeviceChanged(device))
            .addOutputDeviceChangedListener(device -> outputDeviceChanged(device))
            .open();
    }

    private void inputDeviceChanged(final Device device) {
        closeInputDevice();
        openInputDevice(device);
    }

    private void outputDeviceChanged(final Device device) {
        closeOutputDevice();
        openOutputDevice(device);
    }

    private void openInputDevice(final Device device) {
        call(() -> {
            if (!device.isOpen()) {
                device.open();
            }
            inputDevice = device;
            updateStatusBar();
        });
    }

    private void closeInputDevice() {
        if (inputDevice != null) {
            if (inputDevice.isOpen()) {
                inputDevice.close();
            }
            inputDevice = null;
            updateStatusBar();
        }
    }

    private void openOutputDevice(final Device device) {
        call(() -> {
            if (!device.isOpen()) {
                device.open();
            }
            outputDevice = device;
            updateStatusBar();
        });
    }

    private void closeOutputDevice() {
        if (outputDevice != null) {
            if (outputDevice.isOpen()) {
                outputDevice.close();
            }
            outputDevice = null;
            updateStatusBar();
        }
    }

    private void updateStatusBar() {
        statusBar.setText(String.format(STATUS_BAR_FORMAT, inputDevice != null ? inputDevice : "-", outputDevice != null ? outputDevice : "-"));
    }
}

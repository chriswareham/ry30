package net.chriswareham.ry30;

import java.awt.BorderLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;

import net.chriswareham.gui.AbstractFrame;
import net.chriswareham.gui.MenuUtils;
import net.chriswareham.midi.Device;

public class Editor extends AbstractFrame {

    private static final long serialVersionUID = 1L;

    public static void main(final String... args) {
        new Editor().open();
    }

    private Voice voice = new Voice();

    private final CommonPanel commonPanel = new CommonPanel();

    private final ElementPanel element1Panel = new ElementPanel();

    private final ElementPanel element2Panel = new ElementPanel();

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
    }

    @Override
    protected void populateInterface() {
        voice.initialise();

        commonPanel.setVoice(voice);
        element1Panel.setElement(voice.getElement1());
        element2Panel.setElement(voice.getElement2());
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
        // XXX
    }

    private void outputDeviceChanged(final Device device) {
        // XXX
    }
}

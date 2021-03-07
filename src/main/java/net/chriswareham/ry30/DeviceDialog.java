package net.chriswareham.ry30;

import java.awt.BorderLayout;
import java.awt.Window;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import net.chriswareham.gui.AbstractDialog;
import net.chriswareham.gui.DefaultButton;
import net.chriswareham.gui.DefaultComboBoxModel;
import net.chriswareham.gui.GridBagPanel;
import net.chriswareham.midi.Device;
import net.chriswareham.midi.MidiUtils;

/**
 * This class provides a dialog for selecting an input and output device.
 */
public class DeviceDialog extends AbstractDialog {
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The listeners to inform when an input device has been selected.
     */
    private final List<DeviceSelectedListener> inputDeviceSelectedlisteners = new CopyOnWriteArrayList<>();

    /**
     * The combo box model for input devices.
     */
    private final DefaultComboBoxModel<Device> inputDeviceComboBoxModel = new DefaultComboBoxModel<>();

    /**
     * The combo box for input devices.
     */
    private final JComboBox<Device> inputDeviceComboBox = new JComboBox<>(inputDeviceComboBoxModel);

    /**
     * The listeners to inform when an output device has been selected.
     */
    private final List<DeviceSelectedListener> outputDeviceSelectedlisteners = new CopyOnWriteArrayList<>();

    /**
     * The combo box model for output devices.
     */
    private final DefaultComboBoxModel<Device> outputDeviceComboBoxModel = new DefaultComboBoxModel<>();

    /**
     * The combo box for output devices.
     */
    private final JComboBox<Device> outputDeviceComboBox = new JComboBox<>(outputDeviceComboBoxModel);

    /**
     * Construct an instance of a dialog for selecting an input and output
     * device.
     *
     * @param parent the parent window
     */
    public DeviceDialog(final Window parent) {
        super(parent, "Device");
    }

    /**
     * Add a listener to inform when an input device has been selected.
     *
     * @param listener a listener to inform when an input device has been selected
     * @return the dialog
     */
    public DeviceDialog addInputDeviceChangedListener(final DeviceSelectedListener listener) {
        inputDeviceSelectedlisteners.add(listener);
        return this;
    }

    /**
     * Add a listener to inform when an output device has been selected.
     *
     * @param listener a listener to inform when an output device has been selected
     * @return the dialog
     */
    public DeviceDialog addOutputDeviceChangedListener(final DeviceSelectedListener listener) {
        outputDeviceSelectedlisteners.add(listener);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void createInterface() {
        getContentPane().setLayout(new BorderLayout(0, 2));

        GridBagPanel panel = new GridBagPanel()
            .addCell("Input Device:")
            .addCell(inputDeviceComboBox, true)
            .endRow()
            .addCell("Output Device:")
            .addCell(outputDeviceComboBox, true)
            .endRow();

        getContentPane().add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new DefaultButton("Close", event -> close()));

        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void populateInterface() {
        inputDeviceComboBoxModel.addRows(MidiUtils.getInputDevices());
        inputDeviceComboBox.addActionListener(event -> inputDeviceSelected());

        outputDeviceComboBoxModel.addRows(MidiUtils.getOutputDevices());
        outputDeviceComboBox.addActionListener(event -> outputDeviceSelected());
    }

    /**
     * Inform the listeners that an input device has been selected.
     */
    private void inputDeviceSelected() {
        inputDeviceSelectedlisteners.forEach(listener -> listener.selected(inputDeviceComboBoxModel.getSelectedRow()));
    }

    /**
     * Inform the listeners that an output device has been selected.
     */
    private void outputDeviceSelected() {
        outputDeviceSelectedlisteners.forEach(listener -> listener.selected(outputDeviceComboBoxModel.getSelectedRow()));
    }
}

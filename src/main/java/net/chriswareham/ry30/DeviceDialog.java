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

public class DeviceDialog extends AbstractDialog {

    private static final long serialVersionUID = 1L;

    private final List<DeviceSelectedListener> inputDeviceSelectedlisteners = new CopyOnWriteArrayList<>();

    private final DefaultComboBoxModel<Device> inputDeviceComboBoxModel = new DefaultComboBoxModel<>();

    private final JComboBox<Device> inputDeviceComboBox = new JComboBox<>(inputDeviceComboBoxModel);

    private final List<DeviceSelectedListener> outputDeviceSelectedlisteners = new CopyOnWriteArrayList<>();

    private final DefaultComboBoxModel<Device> outputDeviceComboBoxModel = new DefaultComboBoxModel<>();

    private final JComboBox<Device> outputDeviceComboBox = new JComboBox<>(outputDeviceComboBoxModel);

    public DeviceDialog(final Window parent) {
        super(parent, "Device");
    }

    public DeviceDialog addInputDeviceChangedListener(final DeviceSelectedListener listener) {
        inputDeviceSelectedlisteners.add(listener);
        return this;
    }

    public DeviceDialog addOutputDeviceChangedListener(final DeviceSelectedListener listener) {
        outputDeviceSelectedlisteners.add(listener);
        return this;
    }

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

    @Override
    protected void populateInterface() {
        inputDeviceComboBoxModel.addRows(MidiUtils.getInputDevices());
        inputDeviceComboBox.addActionListener(event -> inputDeviceSelected());

        outputDeviceComboBoxModel.addRows(MidiUtils.getOutputDevices());
        outputDeviceComboBox.addActionListener(event -> outputDeviceSelected());
    }

    private void inputDeviceSelected() {
        inputDeviceSelectedlisteners.forEach(listener -> listener.selected(inputDeviceComboBoxModel.getSelectedRow()));
    }

    private void outputDeviceSelected() {
        outputDeviceSelectedlisteners.forEach(listener -> listener.selected(outputDeviceComboBoxModel.getSelectedRow()));
    }
}

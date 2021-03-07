package net.chriswareham.ry30;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.chriswareham.gui.DefaultComboBoxModel;
import net.chriswareham.gui.GridBagPanel;
import net.chriswareham.gui.IdentifierTextField;
import net.chriswareham.gui.SliderPanel;

/**
 * This class provides a panel for editing the common values of a voice.
 */
public class CommonPanel extends JPanel {
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The pattern that matches a valid name.
     */
    private static final Pattern NAME_PATTERN = Pattern.compile("[a-zA-Z0-9 ]+");

    /**
     * The name text field.
     */
    private final JTextField nameTextField = new IdentifierTextField(NAME_PATTERN, 8, 8);

    /**
     * The level slider.
     */
    private final SliderPanel levelSlider = new SliderPanel(0, 63);

    /**
     * The pitch EG level slider.
     */
    private final SliderPanel pitchEgLevelSlider = new SliderPanel(-72, 72);

    /**
     * The pitch EG rate slider.
     */
    private final SliderPanel pitchEgRateSlider = new SliderPanel(0, 63);

    /**
     * The polyphonic check box.
     */
    private final JCheckBox polyCheckBox = new JCheckBox();

    /**
     * The alternate group combo box model.
     */
    private final DefaultComboBoxModel<AlternateGroup> alternateGroupComboBoxModel = new DefaultComboBoxModel<>();

    /**
     * The alternate group combo box.
     */
    private final JComboBox<AlternateGroup> alternateGroupComboBox = new JComboBox<>(alternateGroupComboBoxModel);

    /**
     * The output assignment combo box model.
     */
    private final DefaultComboBoxModel<OutputAssign> outputAssignComboBoxModel = new DefaultComboBoxModel<>();

    /**
     * The output assignment combo box.
     */
    private final JComboBox<OutputAssign> outputAssignComboBox = new JComboBox<>(outputAssignComboBoxModel);

    /**
     * The individual output level slider.
     */
    private final SliderPanel individualOutputLevelSlider = new SliderPanel(0, 63);

    /**
     * Construct an instance of a panel for editing the common values of a
     * voice.
     */
    public CommonPanel() {
        super(new GridLayout(1, 3, 4, 4));
        createInterface();
    }

    /**
     * Set the voice to edit.
     *
     * @param voice the voice to edit
     */
    public void setVoice(final Voice voice) {
        nameTextField.setText(voice.getName());
        levelSlider.setValue(voice.getLevel());
        pitchEgLevelSlider.setValue(voice.getPitchEgLevel());
        pitchEgRateSlider.setValue(voice.getPitchEgRate());
        polyCheckBox.setSelected(voice.isPoly());
        alternateGroupComboBoxModel.setSelectedRow(voice.getAlternateGroup());
        outputAssignComboBoxModel.setSelectedRow(voice.getOutputAssign());
        individualOutputLevelSlider.setValue(voice.getIndividualOutputLevel());
    }

    /**
     * Create the interface.
     */
    private void createInterface() {
        alternateGroupComboBoxModel.addRows(AlternateGroup.values());
        outputAssignComboBoxModel.addRows(OutputAssign.values());

        add(createLeftPanel());
        add(createMiddlePanel());
        add(createRightPanel());
    }

    /**
     * Create the left panel.
     *
     * @return the left panel
     */
    private JPanel createLeftPanel() {
        GridBagPanel panel = new GridBagPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return panel
            .addCell("Name:")
            .addCell(nameTextField, true)
            .endRow()
            .addCell("Level:")
            .addCell(levelSlider, 2, true)
            .endRow()
            .addCell("Pitch EG Level:")
            .addCell(pitchEgLevelSlider, 2, true)
            .endRow()
            .addCell("Pitch EG Rate:")
            .addCell(pitchEgRateSlider, 2, true)
            .endRow()
            .addExpandingRow();
    }

    /**
     * Create the middle panel.
     *
     * @return the middle panel
     */
    private JPanel createMiddlePanel() {
        GridBagPanel panel = new GridBagPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return panel
            .addCell("Poly:")
            .addCell(polyCheckBox, true)
            .endRow()
            .addCell("Alternate Group:")
            .addCell(alternateGroupComboBox, true)
            .endRow()
            .addCell("Output:")
            .addCell(outputAssignComboBox, true)
            .endRow()
            .addCell("Individual Output Level:")
            .addCell(individualOutputLevelSlider, true)
            .endRow()
            .addExpandingRow();
    }

    /**
     * Create the right panel.
     *
     * @return the right panel
     */
    private JPanel createRightPanel() {
        return new JPanel();
    }
}

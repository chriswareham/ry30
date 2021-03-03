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

public class CommonPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private static final Pattern NAME_PATTERN = Pattern.compile("[a-zA-Z0-9 ]+");

    private final JTextField nameTextField = new IdentifierTextField(NAME_PATTERN, 8, 8);

    private final SliderPanel levelSlider = new SliderPanel(0, 63);

    private final SliderPanel pitchEgLevelSlider = new SliderPanel(-72, 72);

    private final SliderPanel pitchEgRateSlider = new SliderPanel(0, 63);

    private final JCheckBox polyCheckBox = new JCheckBox();

    private final DefaultComboBoxModel<AlternateGroup> alternateGroupComboBoxModel = new DefaultComboBoxModel<>();

    private final JComboBox<AlternateGroup> alternateGroupComboBox = new JComboBox<>(alternateGroupComboBoxModel);

    private final DefaultComboBoxModel<OutputAssign> outputAssignComboBoxModel = new DefaultComboBoxModel<>();

    private final JComboBox<OutputAssign> outputAssignComboBox = new JComboBox<>(outputAssignComboBoxModel);

    private final SliderPanel individualOutputLevelSlider = new SliderPanel(0, 63);

    public CommonPanel() {
        super(new GridLayout(1, 3, 4, 4));
        createInterface();
    }

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

    private void createInterface() {
        alternateGroupComboBoxModel.addRows(AlternateGroup.values());
        outputAssignComboBoxModel.addRows(OutputAssign.values());

        add(createLeftPanel());
        add(createMiddlePanel());
        add(createRightPanel());
    }

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

    private JPanel createRightPanel() {
        return new JPanel();
    }
}

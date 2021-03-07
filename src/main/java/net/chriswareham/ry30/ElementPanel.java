package net.chriswareham.ry30;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import net.chriswareham.gui.DefaultComboBoxModel;
import net.chriswareham.gui.GridBagPanel;
import net.chriswareham.gui.SliderPanel;

/**
 * This class provides a panel for editing the element values of a voice.
 *
 * <p>TODO : split the pitch sliders to create coarse and fine sliders.</p>
 * <p>TODO : disable filter sliders when "through" filter type is selected.</p>
 * <p>TODO : Handle differing maximum filter cutoff of LPF and HPF.</p>
 */
public class ElementPanel extends JPanel {
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The wave combo box model.
     */
    private final DefaultComboBoxModel<Wave> waveComboBoxModel = new DefaultComboBoxModel<>();

    /**
     * The wave combo box.
     */
    private final JComboBox<Wave> waveComboBox = new JComboBox<>(waveComboBoxModel);

    /**
     * The reverse wave check box.
     */
    private final JCheckBox reverseCheckBox = new JCheckBox();

    /**
     * The level slider.
     */
    private final SliderPanel levelSlider = new SliderPanel(0, 63);

    /**
     * The pan slider.
     */
    private final SliderPanel panSlider = new SliderPanel(-16, 16, 16);

    /**
     * The pitch slider.
     */
    private final SliderPanel pitchSlider = new SliderPanel(-3600, 3600);

    /**
     * The decay slider.
     */
    private final SliderPanel decaySlider = new SliderPanel(0, 63);

    /**
     * The filter type combo box model.
     */
    private final DefaultComboBoxModel<FilterType> filterTypeComboBoxModel = new DefaultComboBoxModel<>();

    /**
     * The filter type combo box.
     */
    private final JComboBox<FilterType> filterTypeComboBox = new JComboBox<>(filterTypeComboBoxModel);

    /**
     * The filter cutoff slider.
     */
    private final SliderPanel filterCutoffSlider = new SliderPanel(0, 128); // XXX max is 115 for HPF

    /**
     * The filter resonance slider.
     */
    private final SliderPanel filterResonanceSlider = new SliderPanel(0, 99);

    /**
     * The filter EG level slider.
     */
    private final SliderPanel filterEgLevelSlider = new SliderPanel(-63, 63);

    /**
     * The filter EG rate slider.
     */
    private final SliderPanel filterEgRateSlider = new SliderPanel(0, 63);

    /**
     * The level sensitivity slider.
     */
    private final SliderPanel levelSensitivitySlider = new SliderPanel(-7, 7);

    /**
     * The pitch sensitivity slider.
     */
    private final SliderPanel pitchSensitivitySlider = new SliderPanel(-7, 7);

    /**
     * The EG sensitivity slider.
     */
    private final SliderPanel egSensitivitySlider = new SliderPanel(-7, 7);

    /**
     * The filter sensitivity slider.
     */
    private final SliderPanel filterSensitivitySlider = new SliderPanel(-7, 7);

    /**
     * Construct an instance of a panel for editing the element values of a
     * voice.
     */
    public ElementPanel() {
        super(new GridLayout(1, 3, 4, 4));
        createInterface();
    }

    /**
     * Set the element to edit.
     *
     * @param element the element to edit
     */
    public void setElement(final Element element) {
        waveComboBoxModel.setSelectedRow(element.getWave());
        reverseCheckBox.setSelected(element.isReverse());
        levelSlider.setValue(element.getLevel());
        panSlider.setValue(element.getPan());
        pitchSlider.setValue(element.getPitch());
        decaySlider.setValue(element.getDecay());
        filterTypeComboBoxModel.setSelectedRow(element.getFilterType());
        filterCutoffSlider.setValue(element.getFilterCutoff());
        filterResonanceSlider.setValue(element.getFilterResonance());
        filterEgLevelSlider.setValue(element.getFilterEgLevel());
        filterEgRateSlider.setValue(element.getFilterEgRate());
        levelSensitivitySlider.setValue(element.getLevelSensitivity());
        pitchSensitivitySlider.setValue(element.getPitchSensitivity());
        egSensitivitySlider.setValue(element.getEgSensitivity());
        filterSensitivitySlider.setValue(element.getFilterSensitivity());
    }

    /**
     * Create the interface.
     */
    private void createInterface() {
        waveComboBoxModel.addRows(Wave.values());
        waveComboBox.addActionListener(event -> waveSelected());
        filterTypeComboBoxModel.addRows(FilterType.values());

        add(createWavePanel());
        add(createFilterPanel());
        add(createSensitivityPanel());
    }

    /**
     * Create the wave panel.
     *
     * @return the wave panel
     */
    private JPanel createWavePanel() {
        GridBagPanel panel = new GridBagPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return panel
            .addCell("Wave:")
            .addCell(waveComboBox, true)
            .addCell("Reverse:")
            .addCell(reverseCheckBox)
            .endRow()
            .addCell("Level:")
            .addCell(levelSlider, 3, true)
            .endRow()
            .addCell("Pan:")
            .addCell(panSlider, 3, true)
            .endRow()
            .addCell("Pitch:")
            .addCell(pitchSlider, 3, true)
            .endRow()
            .addCell("Decay:")
            .addCell(decaySlider, 3, true)
            .endRow()
            .addExpandingRow();
    }

    /**
     * Create the filter panel.
     *
     * @return the filter panel
     */
    private JPanel createFilterPanel() {
        GridBagPanel panel = new GridBagPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return panel
            .addCell("Filter Type:")
            .addCell(filterTypeComboBox, true)
            .endRow()
            .addCell("Filter Cutoff:")
            .addCell(filterCutoffSlider, true)
            .endRow()
            .addCell("Filter Resonance:")
            .addCell(filterResonanceSlider, true)
            .endRow()
            .addCell("Filter EG Level:")
            .addCell(filterEgLevelSlider, true)
            .endRow()
            .addCell("Filter EG Rate:")
            .addCell(filterEgRateSlider, true)
            .endRow()
            .addExpandingRow();
    }

    /**
     * Create the sensitivity panel.
     *
     * @return the sensitivity panel
     */
    private JPanel createSensitivityPanel() {
        GridBagPanel panel = new GridBagPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return panel
            .addCell("Level Sensitivity:")
            .addCell(levelSensitivitySlider, true)
            .endRow()
            .addCell("Pitch Sensitivity:")
            .addCell(pitchSensitivitySlider, true)
            .endRow()
            .addCell("EG Sensitivity:")
            .addCell(egSensitivitySlider, true)
            .endRow()
            .addCell("Filter Sensitivity:")
            .addCell(filterSensitivitySlider, true)
            .endRow()
            .addExpandingRow();
    }

    /**
     * Handle the selection of a wave.
     */
    private void waveSelected() {
        Wave wave = waveComboBoxModel.getSelectedRow();
        reverseCheckBox.setEnabled(wave.ordinal() < Wave.DIG_WAVE.ordinal());
        if (!reverseCheckBox.isEnabled()) {
            reverseCheckBox.setSelected(false);
        }
    }
}

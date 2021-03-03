package net.chriswareham.gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 * This class provides a panel for a label and slider.
 */
public class SliderPanel extends JPanel {
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The offset to apply to the slider value.
     */
    private final int offset;

    /**
     * The label.
     */
    private final JLabel label;

    /**
     * The slider.
     */
    private final JSlider slider;

    /**
     * Construct an instance of the slider panel.
     *
     * @param min the minimum value of the slider
     * @param max the maximum value of the slider
     */
    public SliderPanel(final int min, final int max) {
        this(min, max, 0);
    }

    /**
     * Construct an instance of the slider panel.
     *
     * @param min the minimum value of the slider
     * @param max the maximum value of the slider
     * @param offset the offset to apply to the slider value
     */
    public SliderPanel(final int min, final int max, final int offset) {
        super(new BorderLayout());

        this.offset = offset;

        label = new JLabel();
        add(label, BorderLayout.NORTH);

        slider = new JSlider(min, max);
        add(slider, BorderLayout.CENTER);

        updateLabel();

        slider.addChangeListener(event-> updateLabel());
    }

    /**
     * Get the slider value.
     *
     * @return the slider value
     */
    public int getValue() {
        return slider.getValue() + offset;
    }

    /**
     * Set the slider value.
     *
     * @param value the slider value
     */
    public void setValue(final int value) {
        slider.setValue(value - offset);
    }

    /**
     * Update the label.
     */
    private void updateLabel() {
        label.setText(Integer.toString(slider.getValue()));
    }
}

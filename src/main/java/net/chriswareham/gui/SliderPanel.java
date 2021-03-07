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
     * The listener to notify when the slider has finished updating.
     */
    private SliderPanelListener listener;

    /**
     * Construct an instance of the slider panel.
     *
     * @param min the minimum value of the slider
     * @param max the maximum value of the slider
     */
    public SliderPanel(final int min, final int max) {
        this(min, max, 0, null);
    }

    /**
     * Construct an instance of the slider panel.
     *
     * @param min the minimum value of the slider
     * @param max the maximum value of the slider
     * @param listener the listener to notify when the slider value changes
     */
    public SliderPanel(final int min, final int max, final SliderPanelListener listener) {
        this(min, max, 0, listener);
    }

    /**
     * Construct an instance of the slider panel.
     *
     * @param min the minimum value of the slider
     * @param max the maximum value of the slider
     * @param offset the offset to apply to the slider value
     */
    public SliderPanel(final int min, final int max, final int offset) {
        this(min, max, offset, null);
    }

    /**
     * Construct an instance of the slider panel.
     *
     * @param min the minimum value of the slider
     * @param max the maximum value of the slider
     * @param offset the offset to apply to the slider value
     * @param listener the listener to notify when the slider value changes
     */
    public SliderPanel(final int min, final int max, final int offset, final SliderPanelListener listener) {
        super(new BorderLayout());

        this.offset = offset;

        label = new JLabel();
        add(label, BorderLayout.NORTH);

        slider = new JSlider(min, max);
        add(slider, BorderLayout.CENTER);

        updateLabel();

        slider.addChangeListener(event -> updateLabel());

        this.listener = listener;
    }

    /**
     * Set the listener to notify when the slider has finished updating.
     *
     * @param listener the listener to notify when the slider has finished updating
     */
    public void setListener(final SliderPanelListener listener) {
        this.listener = listener;
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
        if (!slider.getValueIsAdjusting() && listener != null) {
            listener.updated();
        }
    }
}

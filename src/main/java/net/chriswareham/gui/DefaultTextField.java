package net.chriswareham.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JTextField;
import javax.swing.text.Document;

/**
 * This class provides a text field that supports placeholder text.
 */
public class DefaultTextField extends JTextField {
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The placeholder text.
     */
    private String placeholder;

    /**
     * Construct an instance of a text field that supports placeholder text.
     *
     * @param width preferred width of the field in characters
     */
    public DefaultTextField(final int width) {
        this(width, true);
    }

    /**
     * Construct an instance of a text field that supports placeholder text.
     *
     * @param width preferred width of the field in characters
     * @param editable whether the text field is editable
     */
    public DefaultTextField(final int width, final boolean editable) {
        super(width);
        setEditable(editable);
    }

    /**
     * Construct an instance of a text field that supports placeholder text.
     *
     * @param document the document
     * @param value initial value
     * @param width preferred width of the field in characters
     */
    public DefaultTextField(final Document document, final String value, final int width) {
        this(document, value, width, true);
    }

    /**
     * Construct an instance of a text field that supports placeholder text.
     *
     * @param document the document
     * @param value initial value
     * @param width preferred width of the field in characters
     * @param editable whether the text field is editable
     */
    public DefaultTextField(final Document document, final String value, final int width, final boolean editable) {
        super(document, value, width);
        setEditable(editable);
    }

    /**
     * Set the placeholder text.
     *
     * @param placeholder the placeholder text
     */
    public void setPlaceholder(final String placeholder) {
        this.placeholder = placeholder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);

        if (placeholder != null && !placeholder.isBlank() && getText().length() == 0) {
            Insets insets = getInsets();
            int x = insets.left;
            int y = graphics.getFontMetrics().getMaxAscent() + insets.top;

            Graphics2D g = (Graphics2D) graphics;
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(getDisabledTextColor());
            g.drawString(placeholder, x, y);
        }
    }
}

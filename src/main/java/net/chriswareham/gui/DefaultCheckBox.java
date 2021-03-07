package net.chriswareham.gui;

import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

/**
 * This class provides a default check box.
 */
public class DefaultCheckBox extends JCheckBox {
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Construct an instance of the default check box.
     */
    public DefaultCheckBox() {
        this(null, true);
    }

    /**
     * Construct an instance of the default check box.
     *
     * @param enabled whether the button is enabled
     */
    public DefaultCheckBox(final boolean enabled) {
        this(null, enabled);
    }

    /**
     * Construct an instance of the default check box.
     *
     * @param actionListener the action listener to be invoked on a check box selection
     */
    public DefaultCheckBox(final ActionListener actionListener) {
        this(actionListener, true);
    }

    /**
     * Construct an instance of the default check box.
     *
     * @param actionListener the action listener to be invoked on a check box selection
     * @param enabled whether the button is enabled
     */
    public DefaultCheckBox(final ActionListener actionListener, final boolean enabled) {
        createInterface(actionListener, enabled);
    }

    /**
     * Create the interface.
     *
     * @param actionListener the action listener to be invoked on a check box selection
     * @param enabled whether the button is enabled
     */
    private void createInterface(final ActionListener actionListener, final boolean enabled) {
        if (actionListener != null) {
            addActionListener(actionListener);
        }
        setEnabled(enabled);
    }
}

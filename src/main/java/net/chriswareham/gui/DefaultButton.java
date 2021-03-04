package net.chriswareham.gui;

import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;

/**
 * This class provides a default button.
 */
public class DefaultButton extends JButton {
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Construct an instance of the default button.
     *
     * @param text the button label text
     * @param actionListener the action listener to be invoked on a button press
     */
    public DefaultButton(final String text, final ActionListener actionListener) {
        this(text, actionListener, true);
    }

    /**
     * Construct an instance of the default button.
     *
     * @param text the button label text
     * @param actionListener the action listener to be invoked on a button press
     * @param enabled whether the button is enabled
     */
    public DefaultButton(final String text, final ActionListener actionListener, final boolean enabled) {
        super(text);
        createInterface(actionListener, enabled);
    }

    /**
     * Construct an instance of the default button.
     *
     * @param icon the button label icon
     * @param actionListener the action listener to be invoked on a button press
     */
    public DefaultButton(final Icon icon, final ActionListener actionListener) {
        this(icon, actionListener, true);
    }

    /**
     * Construct an instance of the default button.
     *
     * @param icon the button label icon
     * @param actionListener the action listener to be invoked on a button press
     * @param enabled whether the button is enabled
     */
    public DefaultButton(final Icon icon, final ActionListener actionListener, final boolean enabled) {
        super(icon);
        createInterface(actionListener, enabled);
    }

    /**
     * Create the interface.
     *
     * @param actionListener the action listener to be invoked on a button press
     * @param enabled whether the button is enabled
     */
    private void createInterface(final ActionListener actionListener, final boolean enabled) {
        addActionListener(actionListener);
        setEnabled(enabled);
    }
}

package net.chriswareham.gui;

import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

/**
 * This class provides a status bar for frames.
 */
public class StatusBar extends JLabel {
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Construct a new instance of the status bar.
     *
     * @param text the text to be displayed by the status bar
     */
    public StatusBar(final String text) {
        super(text);
        createInterface();
    }

    /**
     * Create the interface.
     */
    private void createInterface() {
        setBorder(new BevelBorder(BevelBorder.LOWERED));
    }
}

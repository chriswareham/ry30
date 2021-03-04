package net.chriswareham.gui;

import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

/**
 * This class provides an application dialog.
 */
public abstract class AbstractDialog extends JDialog {
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The parent window.
     */
    private final Window parent;

    /**
     * Construct a new instance of an application dialog.
     *
     * @param parent the parent window
     * @param title the title of the application dialog
     */
    public AbstractDialog(final Window parent, final String title) {
        super(parent, title, DEFAULT_MODALITY_TYPE);
        this.parent = parent;
    }

    /**
     * Add a window closed listener.
     *
     * @param listener the window closed listener to add
     * @return the application dialog
     */
    public final AbstractDialog addWindowClosedListener(final WindowClosedListener listener) {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(final WindowEvent event) {
                listener.windowClosed(event);
            }
        });
        return this;
    }

    /**
     * Open the dialog.
     */
    public final void open() {
        doCreateInterface();
        doPopulateInterface();

        setVisible(true);
    }

    /**
     * Close the dialog.
     */
    public final void close() {
        setVisible(false);
        dispose();
    }

    /**
     * Set the minimum size of the dialog.
     *
     * @param width the minimum width of the dialog
     * @param height the minimum height of the dialog
     */
    public void setMinimumSize(final int width, final int height) {
        setMinimumSize(new Dimension(width, height));
    }

    /**
     * Call and handles errors for a callback.
     *
     * @param callback the callback to call
     * @return whether the callback completed without errors
     */
    public final boolean call(final Callback callback) {
        return callback.call(this);
    }

    /**
     * Create the interface.
     */
    protected abstract void createInterface();

    /**
     * Populate the interface.
     */
    protected abstract void populateInterface();

    /**
     * Create the interface.
     */
    private void doCreateInterface() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent event) {
                close();
            }
        });

        createInterface();
    }

    /**
     * Populate the interface.
     */
    private void doPopulateInterface() {
        call(this::populateInterface);

        if (getWidth() == 0 || getHeight() == 0) {
            pack();
        }

        setLocationRelativeTo(parent);
    }
}

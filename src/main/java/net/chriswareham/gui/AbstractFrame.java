package net.chriswareham.gui;

import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * This class provides an application frame.
 */
public abstract class AbstractFrame extends JFrame {
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The parent window.
     */
    private final Window parent;

    /**
     * Construct a new instance of the application frame.
     *
     * @param title the title of the application frame
     */
    public AbstractFrame(final String title) {
        this(null, title);
    }

    /**
     * Construct a new instance of the application frame.
     *
     * @param parent the parent window
     * @param title the title of the application frame
     */
    public AbstractFrame(final Window parent, final String title) {
        super(title);
        this.parent = parent;
    }

    /**
     * Add a window closed listener.
     *
     * @param listener the window closed listener to add
     */
    public final void addWindowClosedListener(final WindowClosedListener listener) {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(final WindowEvent event) {
                listener.windowClosed(event);
            }
        });
    }

    /**
     * Open the frame.
     */
    public final void open() {
        doCreateInterface();
        doPopulateInterface();

        setVisible(true);

        interfaceOpened();
    }

    /**
     * Close the frame.
     */
    public final void close() {
        setVisible(false);
        dispose();

        interfaceClosed();
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
     * Can be overridden by sub-classes to implement post-open logic.
     */
    protected void interfaceOpened() {
        // empty
    }

    /**
     * Can be overridden by sub-classes to implement post-close logic.
     */
    protected void interfaceClosed() {
        // empty
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

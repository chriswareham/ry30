package net.chriswareham.gui;

import java.awt.event.WindowEvent;

/**
 * This interface is implemented by classes that want to be notified when a
 * window has been closed.
 */
public interface WindowClosedListener {
    /**
     * Notified when a window has been closed.
     *
     * @param event the window event
     */
    void windowClosed(WindowEvent event);
}

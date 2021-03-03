package net.chriswareham.gui;

import java.awt.Cursor;
import java.awt.Window;

/**
 * This interface provides a wrapper that handles errors for a callback.
 */
@FunctionalInterface
public interface Callback {
    /**
     * The callback to handle errors for.
     *
     * @throws Exception if an error occurs
     */
    void callback() throws Exception;

    /**
     * Call and handles errors for a callback.
     *
     * @param window the window the callback is for
     * @return whether the callback completed without errors
     */
    default boolean call(final Window window) {
        try {
            window.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

            callback();

            window.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            return true;
        } catch (Exception exception) {
            window.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            ErrorDialog.showDialog(window, "Error", exception);

            return false;
        }
    }
}

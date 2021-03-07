package net.chriswareham.gui;

/**
 * This interface is implemented by classes that want to be notified when a
 * slider panel has finished updating.
 */
public interface SliderPanelListener {
    /**
     * Notify the listener that a slider panel has finished updating.
     */
    void updated();
}

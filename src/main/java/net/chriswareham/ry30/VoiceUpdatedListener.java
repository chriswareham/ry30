package net.chriswareham.ry30;

/**
 * This interface is implemented by classes that want to be notified when a
 * voice has been updated.
 */
public interface VoiceUpdatedListener {
    /**
     * Notify the listener that a voice has been updated.
     */
    void updated();
}

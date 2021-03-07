package net.chriswareham.ry30;

/**
 * This class provides utility methods for voices.
 */
public final class VoiceUtils {
    /**
     * Encode a value for a System Exclusive message.
     *
     * @param buf the buffer to encode the value to
     * @param index the index into the buffer to encode the value to
     * @param value the value to encode
     */
    public static void encode(final byte[] buf, final int index, final int value) {
        //
        // TODO : work out a more efficient way to do this
        //
        String str = String.format("%02X", value);
        buf[index] = (byte) str.charAt(0);
        buf[index + 1] = (byte) str.charAt(1);
    }

    /**
     * Generate a checksum for a System Exclusive message.
     *
     * @param buf the buffer containing the System Exclusive message
     * @param from the starting index into the buffer to generate the checksum for
     * @param to the ending index into the buffer to generate the checksum for
     * @return a checksum
     */
    public static byte checksum(final byte[] buf, final int from, final int to) {
        int sum = 0;

        for (int i = from; i <= to; ++i) {
            sum += buf[i];
        }

        return (byte) (-sum & 0x7F);
    }

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private VoiceUtils() {
        super();
    }
}

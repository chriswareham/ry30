package net.chriswareham.ry30;

/**
 * This class provides utility methods for voices.
 */
public final class VoiceUtils {
    /**
     * The ASCII representation of hex values.
     */
    private static final byte[] HEX_ASCII = {0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46};

    /**
     * Encode a value for a System Exclusive message.
     *
     * @param buf the buffer to encode the value to
     * @param index the index into the buffer to encode the value to
     * @param value the value to encode
     */
    public static void encode(final byte[] buf, final int index, final int value) {
        assert value >= 0 && value <= 255;
        buf[index] = HEX_ASCII[value / 16];
        buf[index + 1] = HEX_ASCII[value % 16];
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

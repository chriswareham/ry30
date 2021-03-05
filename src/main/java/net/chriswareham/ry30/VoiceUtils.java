package net.chriswareham.ry30;

public final class VoiceUtils {

    public static void encode(final byte[] buf, final int index, final int value) {
        //
        // TODO : work out a more efficient way to do this
        //
        String str = String.format("%02X", value);
        buf[index] = (byte) str.charAt(0);
        buf[index + 1] = (byte) str.charAt(1);
    }

    public static byte checksum(final byte[] buf, final int from, final int to) {
        int sum = 0;

        for (int i = from; i <= to; ++i) {
            sum += buf[i];
        }

        return (byte) (-sum & 0x7F);
    }

    private VoiceUtils() {
        super();
    }
}

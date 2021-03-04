package net.chriswareham.ry30;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VoiceUtilsTest {

    @Test
    public void encode0() {
        assertEquals(0, 0x30, 0x30);
    }

    @Test
    public void encode1() {
        assertEquals(1, 0x30, 0x31);
    }

    @Test
    public void encode9() {
        assertEquals(9, 0x30, 0x39);
    }

    @Test
    public void encode10() {
        assertEquals(10, 0x30, 0x41);
    }

    @Test
    public void encode128() {
        assertEquals(128, 0x38, 0x30);
    }

    @Test
    public void encodeAsciiUppercaseA() {
        assertEquals('A', 0x34, 0x31);
    }

    @Test
    public void encodeAsciiUppercaseZ() {
        assertEquals('Z', 0x35, 0x41);
    }

    @Test
    public void encodeAsciiLowercaseA() {
        assertEquals('a', 0x36, 0x31);
    }

    @Test
    public void encodeAsciiLowercaseZ() {
        assertEquals('z', 0x37, 0x41);
    }

    @Test
    public void encodeAsciiSpace() {
        assertEquals(' ', 0x32, 0x30);
    }

    private void assertEquals(final int value, final int a, final int b) {
        int[] buf = {0, 0};
        VoiceUtils.encode(buf, 0, value);
        Assertions.assertEquals(a, buf[0]);
        Assertions.assertEquals(b, buf[1]);
    }
}

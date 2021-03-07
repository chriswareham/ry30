package net.chriswareham.ry30;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VoiceUtilsTest {

    @Test
    public void encode0() {
        encodeAssertEquals(0, 0x30, 0x30);
    }

    @Test
    public void encode1() {
        encodeAssertEquals(1, 0x30, 0x31);
    }

    @Test
    public void encode9() {
        encodeAssertEquals(9, 0x30, 0x39);
    }

    @Test
    public void encode10() {
        encodeAssertEquals(10, 0x30, 0x41);
    }

    @Test
    public void encode128() {
        encodeAssertEquals(128, 0x38, 0x30);
    }

    @Test
    public void encodeAsciiUppercaseA() {
        encodeAssertEquals('A', 0x34, 0x31);
    }

    @Test
    public void encodeAsciiUppercaseZ() {
        encodeAssertEquals('Z', 0x35, 0x41);
    }

    @Test
    public void encodeAsciiLowercaseA() {
        encodeAssertEquals('a', 0x36, 0x31);
    }

    @Test
    public void encodeAsciiLowercaseZ() {
        encodeAssertEquals('z', 0x37, 0x41);
    }

    @Test
    public void encodeAsciiSpace() {
        encodeAssertEquals(' ', 0x32, 0x30);
    }

    private void encodeAssertEquals(final int value, final int a, final int b) {
        byte[] buf = {0, 0};
        VoiceUtils.encode(buf, 0, value);
        Assertions.assertEquals(a, buf[0]);
        Assertions.assertEquals(b, buf[1]);
    }
}

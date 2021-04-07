# Yamaha RY30 Editor

Cross platform editor for the Yamaha RY30 drum machine.

## Requirements

To build, the following are required:

* Java JDK, version 11 or later
* Apache Maven, version 3.6 or later

The tool can be built with the following command:

```
mvn package
```

To run, the following are required:

* Java JRE, version 11 or later

Once built, the tool can be run with the following command:

```
java -jar target/ry30-*.jar
```

## Example Voice Request

```
amidi -p hw:4,0,0 -S F043207A4C4D202030303137202000000000000000000000000000000000F7 -d
```

Byte | Description
---- | -----------
`F0` | # Header
`43` | # Yamaha manufacturer ID
`20` | # Device number (least significant nibble)
`7A` | # Indicates a single voice request
`4C 4D 20 20 30 30 31 37 20 20 00 00 00 00 00 00 00 00 00 00 00 00 00 00` | ID in ASCII followed by 14 null bytes : "LM  0017  "
`00` | # Source voice number
`00` | # Destination voice number
`F7` | # Footer

## Example Voice Response

```
F043007A00764C4D20203030313720200000000000000000000000000000000033463438303038303346344236393642323034343732373933314646464646463036334630453230303031463031363530303346303030373030303030303037334631323146303031463031354530303346303030373030303030302CF7
```

Byte    | Description
------- | -----------
`F0`    | Header
`43`    | Yamaha manufacturer ID
`00`    | Device number (least significant nibble)
`7A`    | Indicates a single voice response
`00 76` | Size of data in bytes : `118`
`4C 4D 20 20 30 30 31 37 20 20 00 00 00 00 00 00 00 00 00 00 00 00 00 00` | ID in ASCII followed by 14 null bytes : `"LM  0017  "`
`00`    | Source voice number
`00`    | Destination voice number
`33 46` | Voice level
`34 38` | Pitch EG level
`30 30` | Pitch EG rate
`38 30` | Poly on / off (most significant bit), Alternate group (least significant three bits of most significant nibble), Output assign (least significant nibble)
`33 46` | Individual output level
`34 42 36 39 36 42 32 30 34 34 37 32 37 39 33 31` | Voice name
`46 46` | Always 0xFF
`46 46` | Always 0xFF
`46 46` | Always 0xFF
`30 36` | Wave 1
`33 46` | Wave 1 level
`30 45` | Wave 1 pan
`32 30 30 30` | Wave 1 pitch
`31 46` | Wave 1 decay
`30 31` | Wave 1 filter type
`36 35` | Wave 1 filter cutoff
`30 30` | Wave 1 filter resonance
`33 46` | Wave 1 filter EG level
`30 30` | Wave 1 filter EG rate
`30 37` | Wave 1 level sensitivity
`30 30` | Wave 1 pitch sensitivity
`30 30` | Wave 1 EG sensitivity
`30 30` | Wave 1 filter sensitivity
`30 37` | Wave 2
`33 46` | Wave 2 level
`31 32` | Wave 2 pan
`31 46 30 30` | Wave 2 pitch
`31 46` | Wave 2 decay
`30 31` | Wave 2 filter type
`35 45` | Wave 2 filter cutoff
`30 30` | Wave 2 filter resonance
`33 46` | Wave 2 filter EG level
`30 30` | Wave 2 filter EG rate
`30 37` | Wave 2 level sensitivity
`30 30` | Wave 2 pitch sensitivity
`30 30` | Wave 2 EG sensitivity
`30 30` | Wave 2 filter sensitivity
`2C`    | Checksum
`F7`    | Footer

The data is hex values encoded into ASCII. For instance, `0xFF` is encoded as
"FF" (ASCII character `0x46` twice).

## Checksum

The `buf` argument points to the contents of a voice message.

```c
char
checksum(const char *buf) {
    int sum = 0;

    for (int i = 6; i < 124; ++i) {
        sum += buf[i];
    }

    return (char) (-sum & 0x7F);
}
```

# Author

Chris Wareham chris@chriswareham.net

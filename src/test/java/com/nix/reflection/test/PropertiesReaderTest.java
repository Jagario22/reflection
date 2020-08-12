package com.nix.reflection.test;

import com.nix.reflection.reader.PropertiesReader;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

/*
lang=EN
window.mode=full_screen
mouse_sensitivity=13
screen.width=1920
screen.height=1080
graphics.texture=high
graphics.shadow=low
vertical_sync=false
 */


class PropertiesReaderTest {

    @Test
    void testResultsOfReadingProperties() {
        Properties props = new PropertiesReader("app.properties").read();

        assertEquals("13", props.get("mouse_sensitivity"));
        assertEquals("1080", props.get("screen.height"));
        assertEquals("1920", props.get("screen.width"));
        assertEquals("low", props.get("graphics.shadow"));
        assertEquals("high", props.get("graphics.texture"));
        assertEquals("EN", props.get("lang"));
        assertEquals("false", props.get("vertical_sync"));
        assertEquals("full_screen", props.get("window.mode"));
    }
}

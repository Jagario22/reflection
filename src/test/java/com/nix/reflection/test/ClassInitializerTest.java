package com.nix.reflection.test;

import static org.junit.jupiter.api.Assertions.*;

import com.nix.reflection.reader.PropertiesReader;
import com.nix.reflection.AppProperties;
import com.nix.reflection.initializer.ClassInitializer;
import org.junit.jupiter.api.Test;

import java.util.Properties;

class ClassInitializerTest {

    @Test
    void testInitializingObject() {
        final String path = "app.properties";
        Properties props = new PropertiesReader(path).read();

        AppProperties instance = new AppProperties();
        ClassInitializer<AppProperties> classInitializer = new ClassInitializer<>(instance);
        classInitializer.initializeByProperties(props);

        assertEquals(13, instance.mouse_sensitivity);
        assertEquals(1080, instance.screen_height);
        assertEquals(1920, instance.screen_width);
        assertEquals("low", instance.graphics_shadow);
        assertEquals("high", instance.graphics_texture);
        assertEquals("EN", instance.language);
        assertFalse(instance.vertical_sync);
        assertEquals("full_screen", instance.window_mode);
        assertTrue(instance.testField);
    }
}

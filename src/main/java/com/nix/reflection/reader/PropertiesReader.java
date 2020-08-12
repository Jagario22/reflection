package com.nix.reflection.reader;

import java.io.*;
import java.util.Properties;

public class PropertiesReader {
    private String path;

    public PropertiesReader(String path) {
        this.path = path;
    }

    public Properties read() {
        Properties prop = null;
        try (FileInputStream fis = new FileInputStream(path)) {
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

}

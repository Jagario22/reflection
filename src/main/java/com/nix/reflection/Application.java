package com.nix.reflection;

import com.nix.reflection.initializer.ClassInitializer;
import com.nix.reflection.reader.PropertiesReader;

import java.util.Properties;

public class Application {
    public static void main(String[] args) {
        AppProperties instance = new AppProperties();
        final String path = "app.properties";
        Properties props = new PropertiesReader(path).read();

        new ClassInitializer<>(instance).initializeByProperties(props);
        System.out.println(instance.toString());
    }
}

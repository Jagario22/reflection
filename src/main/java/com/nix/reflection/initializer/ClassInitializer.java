package com.nix.reflection.initializer;

import com.nix.reflection.annotation.PropertyKey;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.Properties;

public class ClassInitializer<T> {
    private T instance;

    public ClassInitializer(T instance) {
        this.instance = instance;
    }

    public void initializeByProperties(Properties props) {
        Class<?> classOfInstance = instance.getClass();
        for (Field field : classOfInstance.getDeclaredFields()) {
            PropertyKey annotation = field.getAnnotation(PropertyKey.class);

            if (annotation == null)
                continue;

            String value = props.getProperty(annotation.value());
            setField(field, value);
        }
    }


    private void setField(@NotNull Field field, String value) {
        String typeName = field.getType().getName();
        try {
            if (int.class.getName().equals(typeName)) {
                field.setInt(instance, Integer.parseInt(value));
            } else if (long.class.getName().equals(typeName)) {
                field.setLong(instance, Long.parseLong(value));
            } else if (boolean.class.getName().equals(typeName)) {
                field.setBoolean(instance, Boolean.parseBoolean(value));
            } else {
                field.set(instance, value);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

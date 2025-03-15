package main.java.ru.task.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Утилити-класс для работы с проперти файлами
 * При инициализации загружает свойства из файла application.properties и предоставляет доступ к ним
 */
public final class PropertyUtil {

    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    private PropertyUtil() {
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    private static void loadProperties() {
        try (var reader = new FileReader("src/main/resources/application.properties")) {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


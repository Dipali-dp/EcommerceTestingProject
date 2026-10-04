package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public static void loadProperties() {

        properties = new Properties();

        try {

            InputStream input =
                    ConfigReader.class
                            .getClassLoader()
                            .getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException(
                        "config.properties file not found in src/test/resources"
                );
            }

            properties.load(input);
            input.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {

        if (properties == null) {
            loadProperties();
        }

        return properties.getProperty(key);
    }
}
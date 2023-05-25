package utils;

import java.io.IOException;
import java.util.Properties;

public class SuiteConfiguration {

    private static final String APPLICATION_PROPERTIES = "/application.properties";

    private final Properties properties;

    public SuiteConfiguration() {
        properties = new Properties();
        try {
            properties.load(SuiteConfiguration.class.getResourceAsStream(System.getProperty("application.properties", APPLICATION_PROPERTIES)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProperty(String name) {
        return properties.getProperty(name);
    }
}

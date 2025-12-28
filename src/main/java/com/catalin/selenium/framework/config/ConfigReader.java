package com.catalin.selenium.framework.config;

import com.catalin.selenium.framework.exceptions.ConfigurationException;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    //    class for loading the config.properties file only once
    private static final Properties properties = new Properties();

    public ConfigReader(String configFile) {
        loadConfig(configFile);
    }

    private void loadConfig(String configFile) {
        try (InputStream inputStream =
                     getClass()
                             .getClassLoader()
                             .getResourceAsStream(configFile)) {

            if (inputStream == null) {
                throw new ConfigurationException(configFile + "not found in classpath");
            }
            properties.load(inputStream);
        } catch (Exception e) {
            throw new ConfigurationException("Failed to load configuration file: " + configFile);
        }
    }

    public String get(String key) {
        String value = properties.getProperty(key);

        if (value == null) {
            throw new ConfigurationException("Missing configuration key: " + key);
        }
        return value;
    }

    public int getInt(String key) {
        try {
            return Integer.parseInt(get(key));
        } catch (NumberFormatException e) {
            throw new ConfigurationException(
                    "Invalid integer value for key: " + key, e
            );
        }
    }

    public boolean getBoolean (String key) {
        return Boolean.parseBoolean(get(key));
    }
}

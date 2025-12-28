package com.catalin.selenium.framework.config;

public final class ConfigManager {

    private static ConfigReader config;

    private ConfigManager() {
    }

    public static void init(ConfigReader configReader) {
        config = configReader;
    }

    public static ConfigReader getConfig() {
        if (config == null) {
            throw new IllegalStateException(
                    "ConfigManager not initialized. Call init() first."
            );
        }
        return config;
    }
}

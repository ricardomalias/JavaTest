package com.ricardomalias.test.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyConfig {

    private PropertyConfig() {
    }

    public static Properties getProperties() {
        Properties appProps = new Properties();

        Path path = Paths.get("src", "main", "resources");
        File absoluteFile = path.toFile().getAbsoluteFile();
        String s1 = absoluteFile + "/application.properties";

        try {
            appProps.load(new FileInputStream(s1));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return appProps;
    }
}

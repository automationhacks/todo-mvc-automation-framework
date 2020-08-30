package core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    String file = "test_env.properties";
    private static Properties props;

    public String getBaseURI() {
        return props.getProperty("app.base_url");
    }

    public PropertiesReader() {
        props = readPropertiesFile(file);
    }

    public Properties readPropertiesFile(String fileName) {
        Properties props = null;
        try {
            props = new Properties();
            InputStream in = this.getClass().getClassLoader().getResourceAsStream(fileName);
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return props;
    }
}


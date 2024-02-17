package utilities;

import java.util.ResourceBundle;

public class ConfigReader {
    public static String getProperty(String key) {
        return ResourceBundle.getBundle("config").getString(key);
    }
}
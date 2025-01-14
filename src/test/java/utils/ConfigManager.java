package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author jp
 * Esta Clase esta creada para leer configuraciones desde el archivo de propiedades desde la creacion de un
 * objeto "FileInputStream" donde tiene asiganada una ruta especifica del cual leer los archivos.
 */

public class ConfigManager {

    public static Properties readPropertiesFile() {
        ConfigManager prop = new ConfigManager();
        Properties props = new Properties();
        try {
            InputStream input = new FileInputStream("./src/test/java/utils/config.properties");
            props.load(input);

        } catch (Exception e) {
            e.getStackTrace();
        }
        return props;
    }
}

package helper;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertyUtil {

    private static PropertyUtil instance = null;
    private Properties properties;
    private static String pathResources;
    public static final String PATH_PROPERTY_FILE_LOCAL = "src/main/resources";
    public static final String PROPERTY_FILE = "/app.properties";

    private PropertyUtil() {
        pathResources = PATH_PROPERTY_FILE_LOCAL;
        init();
    }

    public static PropertyUtil getInstance() {
        if (null == instance) {
            instance = new PropertyUtil();
        }
        return instance;
    }

    private void init() {
        properties = new Properties();
        try (InputStream inpStr = new FileInputStream(pathResources+PROPERTY_FILE)) {
            properties.load(inpStr);
        } catch (IOException e) {
           //
        }
    }


    public Properties getProperties() {
        return properties;
    }
}


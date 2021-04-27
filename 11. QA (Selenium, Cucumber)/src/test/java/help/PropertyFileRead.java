package help;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileRead {
    private Properties prop = new Properties();
    private static final Logger LOG = LoggerFactory.getLogger(PropertyFileRead.class);

    public String getProp(String properties) {
        InputStream input = null;
        try {
            input = new FileInputStream("config.properties");
        } catch (FileNotFoundException e) {
            LOG.error(String.valueOf(e));
        }
        try {
            prop.load(input);
        } catch (IOException e) {
            LOG.error(String.valueOf(e));
        }
        return prop.getProperty(properties);
    }
}
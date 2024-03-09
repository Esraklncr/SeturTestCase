package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigReader {


    static Properties properties;
    static {

        String dosyayolu="comfiguration.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyayolu);
            properties = new Properties();
            properties.load(fis);

        }

        catch (IOException e){
            System.out.println("propertıes dosyası okunamadı");

        }

    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }


}

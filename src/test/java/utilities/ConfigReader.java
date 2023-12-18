package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConfigReader {
    public static String getProperty(String key) {
        return ResourceBundle.getBundle("config").getString(key);
    }



    /*public static Properties properties;
    static{
        String filePath="src/test/resources/config.properties";
        try {
            FileInputStream fis=new FileInputStream(filePath);
            // fis dosyayolunu tanimladigimiz configuration.properties dosyasini okudu
            properties=new Properties();
            properties.load(fis); // fis'in okudugu bilgileri properties'e yukledi
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty2(String key){
        *//*
          test method'undan yolladigimiz string key degerini alip
          Properties class'indan getProperty( ) method'unu kullanarak
          bu key'e ait value'u bize getirdi
         *//*
        return properties.getProperty(key);
    }*/
}
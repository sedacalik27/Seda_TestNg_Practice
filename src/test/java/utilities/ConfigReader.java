package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /*
       .properties dosyasındaki datalara ulaşabilmek için return type'ı String olan parametreli static bir method oluştururuz.
   Bu method içinde Properties class'ından bir oble oluştururuz. Ve FileInputStream ile .properties uzantili
   dosyamızı akışa alır, Properties class'ından oluşturduğumuz obje'ye akışa aldığımız dosyayı load() methodu ile
   yükleriz. Ve son olarak Properties class'ından oluşturduğumuz obje ile getProperty() methodunu kullanır ve
   girelen key'in değerini bize return eder.
    */
    public static String getProperty(String key){

        Properties properties = new Properties();

        try {
            FileInputStream fis = new FileInputStream("Configuration.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties.getProperty(key);
    }
}

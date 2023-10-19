package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    static WebDriver driver;
    public static WebDriver getDriver(){
        /*
            Driver'i her çağırdığımızda yeni bir pencere açmamasi için bir if bloğu ile bu işi çözdük.
        if(driver == null) ile eğer driver'a değer atanmamış ise driver'a değerleri ata, tekrar driver
        çağrıldığında driver da değer olduğu için direk driver'i return et. Dolayısıyla driver'ı ikinci kez
        çağırdığımızda açık gördüğü browser da yani aynı sayfada belirtilen web sitene gider.
         */
        if (driver==null){
            switch (ConfigReader.getProperty("browser")){//configuration.propertiesden value geliyor
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }


    public static void closeDriver(){
        /*
            Driver'i direk kapatip tekrar bir sayfaya gitmek istersek hata alırız. Çünkü
        Driver'in yeniden oluşma şartı değer atanmamış olması. Close yaptıktan sonra driver hala
        değer atılı durumda gözükür dolayısıyla yeniden driver'ı oluşturabilmesi için yani getDriver()
        methodundaki oluşma şartına uyabilmesi için driver'i tekrar null' a eşitlememiz yani
        kapandıktan sonra boş olduğunu belirtmemiz gerekir
         */
        if(driver!=null){
            driver.close();
            driver = null;
        }
    }
    public static void quitDriver(){
        if(driver!=null){
            driver.quit();//açılan butun pencereleri kapatıyor
            driver = null;
        }
    }
}

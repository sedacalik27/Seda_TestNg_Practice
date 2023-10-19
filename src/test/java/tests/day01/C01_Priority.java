package tests.day01;

//testcaselerimizi bu package altında oluşturacagız

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Priority {//Priority ==>oncelik

    // amazon isimli bir test methodu olusturunuz. Ve amazona gidiniz
    // bestbuy isimli bir test methodu olusturunuz. Ve bestbuy'a gidiniz
    // techproeducation isimli bir test methodu olusturunuz. Ve techproeducation'a gidiniz


    // once techproeducation, sonra amazon, sonra bestbuy test methodu calısacak sekilde sıralama yapınız

    WebDriver driver;//class seviyesine taşıdım
    @BeforeMethod//her test methodundan önce çalışır
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test(priority = -2)
    public void amazon() {
        driver.get("https://www.amazon.com");



    }


    @Test()
    public void bestbuy() {
        driver.get("https://www.bestbuy.com");

    }

    @Test(priority = -5)
    public void techproeducation() {
        driver.get("https://www.techproeducation.com");
    }


     /*
    TestNg, test methodlarını isim sırasına gore calıstırır.
    Eger isim sıralamasının dısında bir sıralama ile calısmasını isterseniz
    o zaman test methodlarına öncelik(priority) tanımlayabiliriz.


    priority kucukten buyuge gore calısır
    Eger bir test methoduna priority atanmamıssa
    default olarak priority=0 kabul edilir.
     */



}

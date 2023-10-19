package tests.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C04_SoftAssert {//sadece test ng frameworkunde var
    // "https://amazon.com" sayfasına gidiniz
    // Title'in "Amazon" icerdigini test edin
    // Arama kutusunun erisilebilir oldugunu test edin
    // Arama kutusuna Nutella yazıp aratın
    // Sonuc yazısının gorunur oldugunu test edin
    // Sonuc yazısının "Nutella" icerdigini test edin

    // test islemlerini softAssert ile yapınız ve hatalar icin mesaj versin

        WebDriver driver;
    @BeforeMethod//bu classta sadece bir tane test çalıştıracagımız için before class kullanmadık
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        // "https://amazon.com" sayfasına gidiniz
        driver.get("https://amazon.com");

        // Title'in "Amazon" icerdigini test edin
        SoftAssert softAssert = new SoftAssert();
        //softassert methodu instance bir method oldugundan farklı bir classtan kullanabilmek
        // için obje oluşturarark kullanıyoruz. static değil


        String amazonTitle = driver.getTitle();
        softAssert.assertTrue(amazonTitle.contains("Amazon"), "TİTLE AMAZON İCERMİYOR");

        // Arama kutusunun erisilebilir oldugunu test edin
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        softAssert.assertTrue(aramaKutusu.isEnabled());

        // Arama kutusuna Nutella yazıp aratın
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // Sonuc yazısının gorunur oldugunu test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYazisi.isDisplayed(), "SONUC YAZISI GORULMUYOR");


        // Sonuc yazısının "Nutella" icerdigini test edin
        softAssert.assertTrue(sonucYazisi.getText().contains("Nutella"), "SONUC YAZISI NUTELLA İCERMİYOR");

        softAssert.assertAll();//bunun sayesinde karşılaştıgı tüm hataları listeleyecek
        // yazıp tum hataları listelemesini istemeliyiz. Aksi halde vermez.


        // eger burada bir hatayla karşılaşmazsa burakı yazdırır
        //eger burada hatayı listelerse kodlar çalışmayı durdurur ve burakı okumaz
        System.out.println("burak");


    }


    /*
JUnitte Assert kullandıgımızda Assert Faild oldugu anda test calısmayı durduruyor.
Ve geri kalanını calıstırmıyordu.

TestNG'de hem Assert, hem softAssert yapıları var.
Test sonuna kadar calıssın, test'in sonunda tum hataları listelesin istiyorsak softAssert kullanırız.

softAssert'un hata bulsa bile calısmaya devam etme ozelligi softAssert.assertAll'a kadardır.
Eger softAssert.assertAll'da hata bulunursa calısma durur. Ve class'ın kalan kısmı calısmaz.

 */
}

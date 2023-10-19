package tests.day01;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_PageClassKullanimi {

    // facebook anasayfaya gidin
    // kullanıcı email kutusuna rastgele bir isim yazın
    // kullanıcı sifre kutusuna rastgele bir password yazın
    // giris yap butonuna tıklayın
    // lutfen bu hesabı baska sekilde tanımla yazı elementinin, gorunur oldugunu test edin
    // sayfayı kaptın


    @Test
    public void test01() {

        //*driver classtan before ları alıyoruz artık befora yapmamıza gerek yok
        //*şimdi lacatelari alıp pages package altında oluşşturucaz





        // facebook anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        // kullanıcı email kutusuna rastgele bir isim yazın
        //page sayfasından locatei alabilmelk için obje oluşturucaz
        FacebookPage facebookPage=new FacebookPage();
        facebookPage.emailKutusu.sendKeys("Mehmetu");



        // kullanıcı sifre kutusuna rastgele bir password yazın
        facebookPage.sifreKutusu.sendKeys("1234567");

        // giris yap butonuna tıklayın
        facebookPage.girisYapButonu.click();

        // lutfen bu hesabı baska sekilde tanımla yazı elementinin, gorunur oldugunu test edin
        Assert.assertTrue(facebookPage.baskaSekildeTanimlaYaziElementi.isDisplayed());

        // sayfayı kaptın
        Driver.closeDriver();
    }
}

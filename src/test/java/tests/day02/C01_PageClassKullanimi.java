package tests.day02;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C01_PageClassKullanimi {

    // amazon sayfasına gidin
    // dropdown'dan "Computers" optionunu secin
    // arama motoruna "Asus" yazıp aratın
    // ikinci urunun fotografını cekin
    // ikinci urune tıklayın
    // title'ının "ASUS" icerdigini test edin
    // sayfayı kapatın


    @Test
    public void test01() throws IOException {
        // amazon sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));



        // dropdown'dan "Computers" optionunu secin

        AmazonPage amazonPage=new AmazonPage();

        Select select=new Select(amazonPage.ddm);//bu parantezin içine dropdownun laceti yazılır

        select.selectByVisibleText("Computers");

        // arama motoruna "Asus" yazıp aratın
        amazonPage.aramaMotoru.sendKeys("Asus", Keys.ENTER);


        // ikinci urunun fotografını cekin
        //çekilen fotografı üstüste kaydetmesin diye localdate time oluşturuyoruz

        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih=date.format(dtf);//şuanın zamanını istediğim şekilde formatla diyorum



        //fotografı nereye kaydedeceğimizi belirtmek için file objesi oluşturduk
        File kayit=new File("target/ekranGoruntusu/kayit"+tarih+".Jpeg");

        //simdi fotografı çekmek için aşagıdaki objeyi oluşturuyoruz

        File gecici= amazonPage.ikinciUrun.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(gecici,kayit);

        // ikinci urune tıklayın
        amazonPage.ikinciUrun.click();

        // title'ının "ASUS" icerdigini test edin
        String title=Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("ASUS"));

        // sayfayı kapatın
        Driver.closeDriver();
























    }
}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.xml.xpath.XPath;

public class FacebookPage {
    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);//bu classa driveri getir demek bu


    }



    // kullanıcı email kutusuna rastgele bir isim yazın
    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailKutusu; //burada bir webelemente assign ettik


    // kullanıcı sifre kutusuna rastgele bir password yazın
    @FindBy(xpath = "//input[@id='pass']")
    public WebElement sifreKutusu;

    // giris yap butonuna tıklayın
     @FindBy(xpath = "//button[@name='login']")
    public WebElement girisYapButonu;



    // lutfen bu hesabı baska sekilde tanımla yazı elementinin, gorunur oldugunu test edin

    @FindBy(xpath = "/h2[@class='uiHeaderTitle']")
    public WebElement baskaSekildeTanimlaYaziElementi;


    //locatenin alınması gereken herşeyin locateini aldık ve buraya depoladık




}

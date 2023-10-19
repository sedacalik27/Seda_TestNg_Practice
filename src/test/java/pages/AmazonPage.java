package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {
    //bu classa amazonun locatelerini depolayacagız


    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }



    // dropdown'dan "Computers" optionunu secin
    //Dropdown 3 adımda handle ediliyordu
   // 1)dropdownun locatei alıyoruz
    @FindBy(xpath = "//select[@id='searchDropdownBox']")
    public WebElement ddm;
    //2) select objesi oluşturuyorduk
    //3)opsiyonlardan birini seçmek



    // arama motoruna "Asus" yazıp aratın
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement aramaMotoru;


    // ikinci urunun fotografını cekin
    @FindBy(xpath = "(//img[@class='s-image'])[3]")
    public WebElement ikinciUrun;


    // ikinci urune tıklayın

    // title'ının "ASUS" icerdigini test edin

    // sayfayı kapatın



    //C02 dataproviderin locateleri
    // Nutella, Java, cigdem ve Netherlands icin arama yapalım
    // sonuc yazısının aradıgımız kelimeyi icerdigini test edelim
    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisi;

    // sayfayı kapatalım



}

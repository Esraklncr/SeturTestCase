package Pages.mainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;
import utilities.ReusableMethod;
import utilities.TestBase;

import java.util.List;

public class mainPageObjects extends TestBase {

    public mainPageObjects(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='ins-close-button']")
    public WebElement popupElementi;

    @FindBy(xpath = "//*[text()='Tümüne izin ver']")
    public WebElement kvkkElementi;

    @FindBy(xpath = "//*[@class='sc-25740042-1 jmbIRo']")
    public WebElement HotelIntroduction;

    @FindBy(xpath = "//input[@class='sc-bde938b1-0 kLxiFo']")
    public  WebElement destinationInput;

    @FindBy(xpath = "(//*[@class='sc-f548111d-5 jIfcUs'])[1]")
    public WebElement antalyaOption;

    @FindBy(xpath = "//*[text()='Giriş - Çıkış Tarihleri']")
    public WebElement startDate;

    @FindBy(xpath = "(//td[@style='width: 33px; height: 32px;'])[61]")
    public WebElement april1;

    @FindBy(xpath = "(//td[@style='width: 33px; height: 32px;'])[67]")
    public WebElement april7;

    @FindBy(xpath = "//*[@class='sc-b2c3f6ee-16 cAZglB']")
    public WebElement accommodation;

    @FindBy(xpath = "(//button[@class='sc-423a98f0-1 fYtyaG'])[2]")
    public WebElement noincrease;

    @FindBy(xpath = "//*[@class='sc-423a98f0-0 iibhk']")
    public WebElement exectedno;

    @FindBy(xpath = "//button[@class='sc-8de9de7b-0 dYTYAP']")
    public WebElement searchbutton;

    public void sayfayaGit(){
        Driver.getDriver().get(baseURL);
        ReusableMethod.bekle(5);
        clickElement(popupElementi);
        clickElement(kvkkElementi);
    }
    public void setururl(){
        ReusableMethod.bekle(3);
        Assert.assertEquals(driver.getCurrentUrl(), baseURL);

    }
    public void antalyazısı(){
        destinationInput.sendKeys("Antalya");
        clickElement(destinationInput);
        clickElement(antalyaOption);
    }

    public void arabutonu(){
        Assert.assertTrue(searchbutton.isDisplayed());
        clickElement(searchbutton);
    }
    public void yetiskinsayısıartı(){
       clickElement(accommodation);
       clickElement(noincrease);
       yetiskinSayısıArttımı();
    }
    public void tarihsecme(){
        ActionPageup();
        clickElement(startDate);
        clickElement(april1);
        clickElement(april7);
    }
    public void oteltabıdefault(){
        isAttributeContains(HotelIntroduction,"class","jmbIRo");
    }
    public void yetiskinSayısıArttımı(){
        System.out.println(accommodation.getText());
        isContains("3",accommodation.getText());
        clickElement(accommodation);
    }

}


package Pages.AntalPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.*;

import java.util.List;
import java.util.Random;

public class AntalPage extends TestBase {
    public AntalPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[@class/='sc-48bfe892-0 hCchhG']")
    public WebElement randombox;

    @FindBy(xpath = "//*[@alt='Setur AppStore']")
    public WebElement appstore;

    @FindBy(xpath = "//*[@class='sc-21021e1e-1 gPQAyQ']")
    public WebElement priceElement;



    public void antalyaurlcontrol() {
        ReusableMethod.bekle(5);
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("antalya"));
    }

    public void otelsayısıControl() {
        List<WebElement> rastgelesecımkutusu = driver.findElements(By.xpath("//*[@class='sc-48bfe892-0 hCchhG']"));
        int ıntotelsayısı = Integer.parseInt(RastegeleTıklama(rastgelesecımkutusu));
        if (ıntotelsayısı > 30) {
            WebElement appstore = driver.findElement(By.xpath("//*[@alt='Setur AppStore']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(false)", appstore);
            ReusableMethod.bekle(5);
            String price = priceElement.getText();
            System.out.println(price);
            Assert.assertTrue(price.contains(Integer.toString(ıntotelsayısı)));
        }

    }
}


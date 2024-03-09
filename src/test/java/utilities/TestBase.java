package utilities;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class TestBase {
    public static WebDriver driver;
    public String baseURL = "https://www.setur.com.tr/";
    public TestBase(){
        driver = Driver.getDriver();
    }


    public static void clickElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        element.click();
    }

    @After
    public void teardown() throws InterruptedException {
    driver.quit();

    }
    public boolean isAttributeContains(WebElement element,String attribute,String beklenen){
  if ( element.getAttribute(attribute).contains(beklenen)){
     return true;
  }else
  {return false;}



    }
    public void ActionPageup(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).perform();
    }
    public void isContains(String beklenen,String asil){
        Assert.assertTrue(asil.contains(beklenen));

    }
    public String RastegeleTıklama(List<WebElement>elements) {
        Random random = new Random();
        int randomIndex = random.nextInt(elements.size());
        WebElement randomelement = elements.get(randomIndex);
        clickElement(randomelement);
        String otelNumber = randomelement.getText().replaceAll("\\D", "");


        return otelNumber;
    }
}
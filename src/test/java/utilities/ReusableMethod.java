package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static utilities.Driver.driver;

public class ReusableMethod {
    public static void bekle(int saniye)
    {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static String tumsayfafotocek(String screensshotsIsmı) {

        //dosya adını dınamık yapalım
        //target/screetshots/tumsayfaSS.png
        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter istenenformat=DateTimeFormatter.ofPattern("yyMMddHHmm");
        localDateTime.format(istenenformat);

        String dınamıkdosyaadı="target/screetshots/"+screensshotsIsmı+
                               localDateTime.format(istenenformat)+".png";



        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File tumsayfafoto =new File(dınamıkdosyaadı);
        File gecıcıdosya=takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(gecıcıdosya,tumsayfafoto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*
        screetshot dosyası ıcın hep aynı ısmı kullanırsak tum cekılen fotolar aynı ısımle
        kaydedılecegınden tek bır dosya olur son cekılen foto eskılerın uzerıne kayıt olur

         cektıgımız fotoların hepsının kalması ve ıstenılen ısımde olması ıcın
         dosya adını dınamık yapalım
         1. methodun cagırıldıgı yerden bır fotograf ısmı yazılsın
         2. methodda dosya ısmıne tarıh etıketı ekleyelım
         ılkurun202310080829 gıbı
         */
        return dınamıkdosyaadı;
    }
      public static void webeleementscreenshotcek(WebElement istenenwebelemeent,String screenshotsısmı) {
          LocalDateTime localDateTime=LocalDateTime.now();
          DateTimeFormatter istenenformat=DateTimeFormatter.ofPattern("yyMMddHHmm");
          localDateTime.format(istenenformat);

          String dınamıkdosyaadı="target/screetshots/"+screenshotsısmı+
                  localDateTime.format(istenenformat)+".png";

          File webelementscreenshots=new File(dınamıkdosyaadı);
          File gecıcıdosya=istenenwebelemeent.getScreenshotAs(OutputType.FILE);
          try {
              FileUtils.copyFile(gecıcıdosya,webelementscreenshots);
          } catch (IOException e) {
              throw new RuntimeException(e);
          }


      }

}

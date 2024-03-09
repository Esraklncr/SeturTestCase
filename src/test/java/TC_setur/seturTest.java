package TC_setur;

import Pages.AntalPage.AntalPage;
import Pages.mainPage.mainPageObjects;

import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class seturTest extends TestBase {
    Logger logger;
    mainPageObjects mainPage;
    AntalPage antalPage;

    public seturTest() {
        mainPage = new mainPageObjects();
        antalPage = new AntalPage();
        logger = LogManager.getLogger();
    }


    @Test
    public void test01() {
        logger.info("https://www.setur.com.tr/ sayfasına gidilir");
        mainPage.sayfayaGit();


        logger.info("setur url’nin geldiği kontrol edilir");
        mainPage.setururl();


        logger.info("Ana sayfada Otel tabının default geldiği kontrol edilir,");
        mainPage.oteltabıdefault();


        logger.info("'Nereye Gideceksiniz?' alanına csv dosyasından 'Antalya' yazılır ve en üsteki Antalya seçeneğine tıklanır");
        mainPage.antalyazısı();


        logger.info("Tarih alanında Nisan’ın ilk haftası için bir haftalık aralık seçilir.");
        mainPage.tarihsecme();


        logger.info("Yetişkin sayısı 1 artırılır ve Yetişkin sayısının değiştiği kontrol edilir.");
        mainPage.yetiskinsayısıartı();


        logger.info("'Ara'butonu’nun görünürlüğü kontrol edilir ve tıklanılır");
       mainPage.arabutonu();


        logger.info("Açılan url içinde “antalya” kelimesini içerdiği kontrol edilir.");
        antalPage.antalyaurlcontrol();

        logger.info("'Diğer Bölgeleri Göster' alanında rastgele tıklama metotu kullanılarak bir seçim yapılır ve '()'içerisinde bulunan sayı kaydedilir.");
        logger.info("Sayfanın altında bulunan 'Antalya Otelleri ve En Uygun Antalya Otel Fiyatları ' alanına kadar ekranda kaydırma yapılır, kaydedilen değerin 8. adımda kaydedilen değerle eşit olduğu kontrol edılır");
        antalPage.otelsayısıControl();

        Driver.quitDriver();
    }
}

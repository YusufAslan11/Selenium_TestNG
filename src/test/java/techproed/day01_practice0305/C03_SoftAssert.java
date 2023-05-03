package techproed.day01_practice0305;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.utilities.TestBase;

public class C03_SoftAssert extends TestBase {


    // "https://amazon.com" sayfasına gidiniz
    /// Title'in "Amazon" icerdigini test edin
    /// Arama kutusunun erisilebilir oldugunu test edin
    // Arama kutusuna nutella yazıp aratın
    /// Sonuc yazısının gorunur oldugunu test edin
    /// Sonuc yazısının "Nutella" icerdigini test edin

    // test islemlerini softAsser ile yapınız ve hatalar icin mesaj versin


    @Test
    public void test01() {

        // "https://amazon.com" sayfasına gidiniz
        driver.get("https://amazon.com");


        /// Title'in "Amazon" icerdigini test edin
        String amazonTitle = driver.getTitle();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(amazonTitle.contains("Amazon"), "TİTLE AMAZON İCERMİYOR");


        /// Arama kutusunun erisilebilir oldugunu test edin
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        softAssert.assertTrue(aramaKutusu.isEnabled(), "ARAMA KUTUSUNA ERİSİLEMİYOR");


        // Arama kutusuna nutella yazıp aratın
        aramaKutusu.sendKeys("nutella" + Keys.ENTER);


        /// Sonuc yazısının gorunur oldugunu test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        softAssert.assertTrue(sonucYazisi.isDisplayed(), "SONUC YAZISI GORUNMUYOR");


        /// Sonuc yazısının "nutella" icerdigini test edin
        softAssert.assertTrue(sonucYazisi.getText().contains("nutella"), "SONUC YAZISI Nutella ICERMIYOR");


        // test islemlerini softAsser ile yapınız ve hatalar icin mesaj versin
        softAssert.assertAll();
        /*
        softAssert.assertAll() yazıp tum hataları listelemesini istemeliyiz. Aksi halde hata vermez.
         */


    }
}
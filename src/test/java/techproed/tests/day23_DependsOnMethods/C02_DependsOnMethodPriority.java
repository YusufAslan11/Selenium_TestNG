package techproed.tests.day23_DependsOnMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_DependsOnMethodPriority {
    /*
    Bu class'ı dependsOnMethods ve priority arasındaki farkı göstermek için açtık
     */
    WebDriver driver;

    @Test
    public void amazonTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(priority = 1)
    public void amazonTest2() {
        driver.get("https://amazon.com");
        //Eğer dependsOnMethods kullanmazsak bu örnek için java.lang.NullPointerException hatası alırız
    }

    @Test(priority = 2)
    public void amazonTest3() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
    }
}

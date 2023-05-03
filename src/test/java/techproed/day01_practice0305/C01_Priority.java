package techproed.day01_practice0305;


import org.testng.annotations.Test;

import techproed.utilities.TestBase;


public class C01_Priority extends TestBase {
    // amazon isimli bir test methodu olusturunuz. Ve amazona gidiniz
    // bestbuy isimli bir test methodu olusturunuz. Ve bestbuy'a gidiniz
    // techproeducation isimli bir test methodu olusturunuz. Ve techproeducation'a gidiniz

    // once techproeducation, sonra amazon, sonra bestbuy test methodu calısacak sekilde sıralama yapınız



    @Test(priority = -2)
    public void amazon() {
        driver.get("https://www.amazon.com");
    }


    @Test(priority = 0)
    public void bestbuy() {
        driver.get("https://www.bestbuy.com");
    }


    @Test(priority = -5)
    public void techproeducation() {
        driver.get("https://www.techproeducation.com");
    }


}

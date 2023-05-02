package techproed.tests.day23_DependsOnMethods;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C02_DT_SoftAssertion {
    @Test
    public void softAssertTest(){
        //1. Adım: Soft Assert objesi oluşturun
        SoftAssert softAssert=new SoftAssert();

        //2. Adım: Assertion yapın:
            //1.assertion
            softAssert.assertEquals(1,2);
            //2.assertion

    }



}

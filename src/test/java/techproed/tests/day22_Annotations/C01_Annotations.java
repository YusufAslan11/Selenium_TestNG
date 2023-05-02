package techproed.tests.day22_Annotations;

import org.testng.annotations.*;

public class C01_Annotations {
        /*
    @Test: Test case oluşturmak için kullanılır.
    @Before ve @After: 5 Before ve 5 After annotation bulunur.
    suite > tests > group > class > method
    @BeforeSuite: Herbir test suitinden önce bir kez çalışır.
    @AfterSuite: Herbir test suitinden sonra bir kez çalışır.
    @BeforeTest: Herbir test öncesi bir kez çalışır.(Herbir test case'i öncesi değil!!!)
    @AfterTest: Herbir test sonrası bir kez çalışır.(Herbir test case'i sonrası değil!!!)
    @BeforeGroups: Belirtilmiş herhangi bir grup öncesi çalışır
    @AfterGroups: Belirtilmiş herhangi bir grup sonrası çalışır
    @BeforeClass: Herbir class'tan önce bir kez çalışır
    @AfterClass: Herbir class'tan sonra bir kez çalışır
    @BeforeMethod: Herbir @Test  annotation'ı öncesi bir kez çalışır.(JUnit @Before annotation'ı gibi)
    @AfterMethod: Herbir @Test  annotation'ı sonrası bir kez çalışır.(JUnit @After annotation'ı gibi)

     */
    @Test
    public void test1(){
            System.out.println("Test 1 Çalıştı");
        }
    @Test
    public void test2() {
        System.out.println("Test 2 Çalıştı");
    }
    @Test
    public void test3() {
        System.out.println("Test 3 Çalıştı");
    }
    @Test
    public void test4() {
        System.out.println("Test 4 Çalıştı");
    }
    @BeforeMethod
    public void setUp() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After Method");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }
    /*
Before Suite
Before Test
Before Class
Before Method
Test 1 Çalıştı
After Method
Before Method
Test 2 Çalıştı
After Method
Before Method
Test 3 Çalıştı
After Method
Before Method
Test 4 Çalıştı
After Method
After Class
After Test
After Suite
     */
}

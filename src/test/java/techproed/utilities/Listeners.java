package techproed.utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Listeners implements ITestListener,IRetryAnalyzer, IAnnotationTransformer {
    /*
    Listeners; TestNG de bir test'in durumunu ve sonucunu izleyen ve bu duruma yanıt veren bir yapıdır.
    Testlerin passed ve failed olma durumlarını, başlangıç ve bitişini takip eder ve raporlayabilir.
        Bunun için TestNG den ITestListener arayüzünü(interface) kullanırız. Oluşturduğumuz Listeners
    class'ına ITestListener arayüzündeki methodları Override etmek için implements ederiz
     */

    @Override
    public void onStart(ITestContext context) {//@BeforeClass gibi
        System.out.println("onStart Methodu -> Tüm testlerden önce tek bir sefer çağrılır "+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish Methodu -> Tüm testlerden sonra tek bir sefer çağrılır "+context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {//@Before gibi
        System.out.println("onTestStart Methodu -> Her bir test'ten önce tek bir sefer çağrılır "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess Methodu -> PASSED olan testlerden sonra tek bir sefer çağrılır "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure Methodu -> FAILED olan testlerden sonra tek bir sefer çağrılır "+result.getName());
        ReusableMethods.tumSayfaResmi(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped Methodu -> SKIP(atlanan) olan testlerden sonra tek bir sefer çağrılır "+result.getName());
    }

    private int retryCount = 0;
    private static final int maxRetryCount = 2;
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
        /*
        Bu method sadece FAIL olan test case'leri tekrar çalıştırır
        maxRetryCount ek olarak çalisma sayısıdır. Bu örnekte Fail olan test (maxRetryCount = 1) normal bir kere
        çalıştıktan sonra fail olursa 1 kez daha çalışacaktır.
         */

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        /*
            Bu methodun amacı; test notasyonlarını, sınıfları, cons.ları ve methodları transform(dönüştürme) etmemize
        olanak sağlar
            Bu method sayesinde Listeners sınıfını .xml dosyasında kullanabileceğiz ve istediğimiz class'ları fail
        olma durumunda listeners sınıfı retry methodunu kullanarak istediğimiz kadar tekrar çalıştırabileceğiz.
         */
        annotation.setRetryAnalyzer(Listeners.class);
    }
}

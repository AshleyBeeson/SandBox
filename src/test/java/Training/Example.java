package Training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class Example {

    private WebDriver webDriver;
    private LoginPage loginPage;

    @Before
    public void before(){
        webDriver = new ChromeDriver();
        loginPage = PageFactory.initElements(webDriver,LoginPage.class);
    }

    @Test
    public void test(){
//        Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
//                .withTimeout(60, MILLISECONDS)
//                .pollingEvery(1, MILLISECONDS);
//
//
//        wait.until(new Function<WebDriver, Boolean>() {
//            int count = 0;
//            public Boolean apply(WebDriver input) {
//                System.out.println(count);
//                count++;
//                return false;
//            }
//        });

        webDriver.switchTo().alert();

        String windowHandle = webDriver.getWindowHandle();
        Set<String> windowHandles = webDriver.getWindowHandles();

        for (String handle : windowHandles){
            if (!handle.equals(windowHandle)){
                webDriver.switchTo().window(handle);
            }
        }


        WebElement el;
//        el.getAttribute("value");
//        webDriver.navigate().to("http://www.qa.com");
//        loginPage.enterUsername("user");
    }

    @After
    public void after(){
        webDriver.quit();
    }


}

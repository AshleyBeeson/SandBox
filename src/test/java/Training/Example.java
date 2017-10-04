package Training;

import com.google.common.base.Function;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import testpages.DemoSiteLoginPage;

import java.util.concurrent.TimeUnit;


public class Example {

    private WebDriver webDriver;
    private DemoSiteLoginPage loginPage;
    private Wait<WebDriver> wait;

    @Before
    public void before(){
        webDriver = new ChromeDriver();
        loginPage = PageFactory.initElements(webDriver, DemoSiteLoginPage.class);
        wait = new FluentWait<WebDriver>(webDriver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(3, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }

    @Test
    public void loginTest() {

        webDriver.navigate().to("http://thedemosite.co.uk/login.php");

        WebElement b = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector("id"));
            }
        });

        loginPage.enterUsername("Username");
        loginPage.enterPassword("Password");
        loginPage.clickLogin();
        boolean verifyLogin = loginPage.verifyLogin();
        Assert.assertTrue("You are not logged in", verifyLogin);
    }

    @After
    public void after(){
        webDriver.quit();
    }


}

package Training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class WebdriverExample {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = WebDriverFactory.getWebDriver("chrome");
        webDriver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void googleTest() {
        webDriver.navigate().to("http://www.qa.com");
        WebElement contactLink = webDriver.findElement(By.cssSelector("#menu > div.navigation-links-hugescreen.visible-f > ul > li:nth-child(7) > div > a > span"));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        contactLink.click();

    }

}

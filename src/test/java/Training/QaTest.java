package Training;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QaTest {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void qaTest() {
        driver.navigate().to("http://www.qa.com");
        String title = driver.getTitle();
        Assert.assertEquals("Page Title not the same", "IT Training | Project Management Training | Business Skills Training | QA", title);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}

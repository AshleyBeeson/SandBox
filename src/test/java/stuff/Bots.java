package stuff;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.base.Function;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.reporting.ExtentReportManager;
import utils.reporting.ReportDetails;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class Bots {

    private WebDriver webDriver;
    private static ExtentReportManager reportManager;
    private Wait<WebDriver> wait;

    @BeforeClass
    public static void init(){
        String property = System.getProperty("user.dir");
        ReportDetails reportDetails = new ReportDetails(property + "\\TestReport",
                "Basic Extent Report","Basic Report");
        reportDetails.setTheme(Theme.DARK);
        reportManager = new ExtentReportManager(ExtentReportManager.ReportType.HTML,reportDetails);
    }

    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
        wait = new FluentWait<WebDriver>(webDriver)
                .withTimeout(60000, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    @AfterClass
    public static void cleanUp(){
        reportManager.clearTests();
    }

    @Test
    public void kahoot() throws InterruptedException {

        webDriver.navigate().to("http://www.kahoot.it");
        TimeUnit.SECONDS.sleep(1);
        WebElement gamePin = webDriver.findElement(By.cssSelector("#inputSession"));
        String pin = "850162";
        gamePin.sendKeys(pin);
        webDriver.findElement(By.cssSelector("#mainView > div > div > div > form > button")).click();

        TimeUnit.SECONDS.sleep(1);

        WebElement nickName = webDriver.findElement(By.cssSelector("#username"));
        String name = "Bot#1";
        nickName.sendKeys(name);

        webDriver.findElement(By.cssSelector("#mainView > div > div > div > form > button")).click();

        try {

            wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.cssSelector("#mainView > div > div.statusbar.top > div.title.ng-binding"));
                }
            });

        } catch (TimeoutException te) {
            fail();
        }

        //#app > main > div > section.question-choices > div

    }

}

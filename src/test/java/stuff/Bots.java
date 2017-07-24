package stuff;

import com.aventstack.extentreports.reporter.configuration.Theme;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.reporting.ExtentReportManager;
import utils.reporting.ReportDetails;

import java.util.concurrent.TimeUnit;

public class Bots {

    private WebDriver webDriver;
    private static ExtentReportManager reportManager;

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

        TimeUnit.SECONDS.sleep(600);

    }

}

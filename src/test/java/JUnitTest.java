import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import testpages.DemoSiteLoginPage;
import utils.ScreenShot;
import utils.reporting.ExtentReportManager;
import utils.reporting.ReportDetails;

import java.io.IOException;
import java.util.Random;

public class JUnitTest {
    private WebDriver webDriver;
    private Random random = new Random();
    private static ExtentReportManager reportManager;

    @BeforeClass
    public static void init(){
        ReportDetails reportDetails = new ReportDetails("C:\\Users\\abeeson\\Desktop\\SandBox\\SandBox\\TestReport","Basic Extent Report","Basic Report");
        reportManager = new ExtentReportManager(ExtentReportManager.ReportType.HTML,reportDetails);
    }

    @Before
    public void setUp(){
        webDriver = new FirefoxDriver();
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
    public void failingTest() throws IOException {
        String testName = "Failing Test";
        reportManager.createTest(testName);
        ExtentTest test = reportManager.getTest(testName);
        boolean pass = false;
        webDriver.navigate().to("http://www.facebook.co.uk");
        test.log(Status.INFO, "Info level message to show information that allows a NONE TECHNICAL person to understand what the test is doing");
        test.log(Status.DEBUG, "Debug level message to display any information a TECHNICAL person might need to know");
        test.log(Status.ERROR, "Error level message to display what went wrong (Can contain the stacktrace of the issue)");

        if (pass){
            test.pass("Test Passed");
        }else{
            test.fail("Test Failed");
            String imagePath = ScreenShot.take(webDriver,"Failing-test-"+ random.nextInt());
            test.addScreenCaptureFromPath(imagePath);
        }
        Assert.assertTrue(pass);
    }

    @Test
    public void passingTest() throws IOException {
        String testName = "Passing Test";
        reportManager.createTest(testName);
        ExtentTest test = reportManager.getTest(testName);
        boolean pass = true;
        test.log(Status.INFO, "Info level message to show information that allows a NONE TECHNICAL person to understand what the test is doing");
        test.log(Status.DEBUG, "Debug level message to display any information a TECHNICAL person might need to know");
        if (pass){
            test.pass("Test Passed");
        }else{
            test.fail("Test Failed");
            String image = ScreenShot.take(webDriver,"Passing-test-"+ random.nextInt());
            test.error("failed: \n" +  test.addScreenCaptureFromPath(image));
        }
        Assert.assertTrue(pass);
    }

    @Test
    public void demoTest(){
        String testName = "Demo Test";
        reportManager.createTest(testName);
        ExtentTest test = reportManager.getTest(testName);
        webDriver.navigate().to("http://thedemosite.co.uk");
        WebElement element = webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)"));
        element.click();

        DemoSiteLoginPage loginPage = PageFactory.initElements(webDriver,DemoSiteLoginPage.class);
        loginPage.enterUsername("USERNAME");
        loginPage.enterPassword("PASSWORD");
        loginPage.clickLogin();

        boolean login = loginPage.verifyLogin();

        if (login){
            test.pass("Successful Login");
        }else{
            test.fail("Failed Login");
        }
        Assert.assertTrue(login);
    }


}

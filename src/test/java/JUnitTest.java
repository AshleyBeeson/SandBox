import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.reporting.ExtentReportManager;
import utils.reporting.ReportDetails;

public class JUnitTest {
    private WebDriver webDriver;
    private static ExtentReportManager reportManager;

    @BeforeClass
    public static void init(){
        ReportDetails reportDetails = new ReportDetails("C:\\Users\\abeeson\\Desktop\\SandBox\\SandBox\\TestReport","Basic Extent Report","Basic Report");
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
    public void failingTest(){
        String testName = "Failing Test";
        reportManager.createTest(testName);
        ExtentTest test = reportManager.getTest(testName);
        boolean pass = false;
        test.log(Status.INFO, "Info level message to show information that allows a NONE TECHNICAL person to understand what the test is doing");
        test.log(Status.DEBUG, "Debug level message to display any information a TECHNICAL person might need to know");
        test.log(Status.ERROR, "Error level message to display what went wrong (Can contain the stacktrace of the issue)");

        if (pass){
            test.pass("Test Passed");
        }else{
            test.fail("Test Failed");
        }
        Assert.assertTrue(pass);
    }

    @Test
    public void passingTest(){
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
        }
        Assert.assertTrue(pass);
    }

}

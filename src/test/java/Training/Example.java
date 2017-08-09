package Training;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

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
        webDriver.navigate().to("http://www.qa.com");
        loginPage.enterUsername("user");
    }

    @After
    public void after(){
        webDriver.quit();
    }


}

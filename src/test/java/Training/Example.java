package Training;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import testpages.DemoSiteLoginPage;

public class Example {

    private WebDriver webDriver;
    private DemoSiteLoginPage loginPage;

    @Before
    public void before(){
        webDriver = new ChromeDriver();
        loginPage = PageFactory.initElements(webDriver, DemoSiteLoginPage.class);
    }

    @Test
    public void loginTest() {

        webDriver.navigate().to("http://thedemosite.co.uk/login.php");

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

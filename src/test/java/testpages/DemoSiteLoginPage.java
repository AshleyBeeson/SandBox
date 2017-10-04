package testpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoSiteLoginPage {

    @FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
    protected WebElement username;

    @FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
    protected WebElement password;

    @FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
    protected WebElement loginButton;

    @FindBy(css = "body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b")
    protected WebElement verifiedLogin;


    public boolean checkUsername() {
        return username.isDisplayed();
    }

    public void enterUsername(String username){

        this.username.sendKeys(username);
    }

    public void enterPassword(String password){
        this.password.sendKeys(password);
    }

    public void clickLogin(){
        loginButton.click();
    }

    public boolean verifyLogin(){
        String text = verifiedLogin.getText();
        System.out.println(text);
        return verifiedLogin.isDisplayed() && !"**Failed Login**".equals(text);
    }

}

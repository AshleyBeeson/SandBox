package Training;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(css = "Selector")
    private WebElement usernameInput;

    @FindBy(css = "Selector")
    private WebElement passwordInput;

    @FindBy(css = "Selector")
    private WebElement submitButton;

    public void enterUsername(String username){
        usernameInput.sendKeys(username);
    }


}

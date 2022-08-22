package by.itacademy.lichess.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasePage {
    @FindBy(xpath = "//input[@name='username']")
    private WebElement inputUsername;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[@class='submit button']")
    private WebElement buttonSubmit;
    @FindBy(xpath = "//a[@href='/signup']")
    private WebElement linkSignup;
    @FindBy(xpath = "//p[@class='error']")
    private WebElement messageLoginFailed;

    public AuthenticationPage typeUsername(String username) {
        inputUsername.sendKeys(username);
        return this;
    }

    public AuthenticationPage typePassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public AuthenticationPage buttonSubmitClick() {
        buttonSubmit.click();
        return this;
    }

    public void waitForLoginErrorMessage(){
        waitForVisibilityOfElement(messageLoginFailed);
    }

    public AuthenticationPage linkSignupClick() {
        linkSignup.click();
        return this;
    }

    public String getErrorMessageText(){
        return messageLoginFailed.getText();
    }

}

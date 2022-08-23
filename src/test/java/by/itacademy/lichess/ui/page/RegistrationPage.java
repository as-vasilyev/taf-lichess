package by.itacademy.lichess.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {
    @FindBy(xpath = "//input[@name='username']")
    private WebElement inputUsername;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//input[@id='submit button text big']")
    private WebElement buttonRegister;
    @FindBy(xpath = "//input[@name='agreement.assistance']")
    private WebElement switchAgreementAssistance;
    @FindBy(xpath = "//input[@name='agreement.nice']")
    private WebElement switchAgreementBeNice;
    @FindBy(xpath = "//input[@name='agreement.account']")
    private WebElement switchAgreementAccount;
    @FindBy(xpath = "//input[@name='agreement.policy']")
    private WebElement switchAgreementPolicy;

    public RegistrationPage typeUsername(String username) {
        inputUsername.sendKeys(username);
        return this;
    }

    public RegistrationPage typePassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public RegistrationPage typeEmail(String email) {
        inputEmail.sendKeys(email);
        return this;
    }

    public RegistrationPage swipeSwitchAgreementAssistance(){
        switchAgreementAssistance.click();
        return this;
    }
    public RegistrationPage swipeSwitchAgreementBeNice(){
        switchAgreementBeNice.click();
        return this;
    }
    public RegistrationPage swipeSwitchAgreementAccount(){
        switchAgreementAccount.click();
        return this;
    }
    public RegistrationPage swipeSwitchAgreementPolicy(){
        switchAgreementPolicy.click();
        return this;
    }

    public RegistrationPage buttonRegisterClick(){
        buttonRegister.click();
        return this;
    }
}

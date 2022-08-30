package by.itacademy.alexey_vasilyev.lichess.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    @FindBy(xpath = "//input[@name='username']")
    private WebElement inputUsername;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//button[@class='submit button text big']")
    private WebElement buttonRegister;
    @FindBy(xpath = "//span[@class='form-check-input']//label[@for='form3-agreement_assistance']")
    private WebElement switchAgreementAssistance;
    @FindBy(xpath = "//span[@class='form-check-input']//label[@for='form3-agreement_nice']")
    private WebElement switchAgreementBeNice;
    @FindBy(xpath = "//span[@class='form-check-input']//label[@for='form3-agreement_account']")
    private WebElement switchAgreementAccount;
    @FindBy(xpath = "//span[@class='form-check-input']//label[@for='form3-agreement_policy']")
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

    public RegistrationPage swipeAcceptAgreementAssistance(){
        switchAgreementAssistance.click();
        return this;
    }
    public RegistrationPage swipeAcceptAgreementBeNice(){
        switchAgreementBeNice.click();
        return this;
    }
    public RegistrationPage swipeAcceptAgreementAccount(){
        switchAgreementAccount.click();
        return this;
    }
    public RegistrationPage swipeAcceptAgreementPolicy(){
        switchAgreementPolicy.click();
        return this;
    }

    public RegistrationPage buttonRegisterClick(){
        buttonRegister.click();
        return this;
    }
}

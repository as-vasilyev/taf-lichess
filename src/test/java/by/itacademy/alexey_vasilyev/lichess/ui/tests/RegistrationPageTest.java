package by.itacademy.alexey_vasilyev.lichess.ui.tests;

import by.itacademy.alexey_vasilyev.lichess.ui.driver.SingletonDriver;
import by.itacademy.alexey_vasilyev.lichess.ui.page.AuthenticationPage;
import by.itacademy.alexey_vasilyev.lichess.ui.steps.IndexPageSteps;
import by.itacademy.alexey_vasilyev.lichess.ui.utils.Utils;
import by.itacademy.alexey_vasilyev.lichess.ui.page.EmailCheckPage;
import by.itacademy.alexey_vasilyev.lichess.ui.page.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BaseTest {
    private final static String URL = "https://lichess.org/";
    private final String generatedUsername = Utils.generateAlphanumericString();
    private final String generatedPassword = Utils.generateAlphanumericString();
    private final String generatedEmail = String.format("%s@mail.ru", Utils.generateAlphanumericString());

    @BeforeTest
    public void BeforeTest() {
        WebDriver webDriver = SingletonDriver.getDriver();
        webDriver.get(URL);
        webDriver.manage()
                .window()
                .maximize();
        IndexPageSteps.navigateToLoginForm();
    }

    @Test
    public void signUpTest() {
        AuthenticationPage authenticationPage = new AuthenticationPage();
        authenticationPage.linkSignupClick();

        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.typeUsername(generatedUsername)
                .typePassword(generatedPassword)
                .typeEmail(generatedEmail)
                .swipeAcceptAgreementAssistance()
                .swipeAcceptAgreementBeNice()
                .swipeAcceptAgreementAccount()
                .swipeAcceptAgreementPolicy()
                .buttonRegisterClick();

        EmailCheckPage emailCheckPage = new EmailCheckPage();
        Assert.assertTrue(emailCheckPage.hasDivConfirmEmailBeenShown);
    }
}

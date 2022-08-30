package by.itacademy.alexey_vasilyev.lichess.ui.tests;

import by.itacademy.alexey_vasilyev.lichess.ui.driver.SingletonDriver;
import by.itacademy.alexey_vasilyev.lichess.ui.page.AuthenticationPage;
import by.itacademy.alexey_vasilyev.lichess.ui.page.IndexPage;
import by.itacademy.alexey_vasilyev.lichess.ui.steps.AuthenticationPageSteps;
import by.itacademy.alexey_vasilyev.lichess.ui.steps.IndexPageSteps;
import by.itacademy.alexey_vasilyev.lichess.ui.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AuthenticationPageTest extends BaseTest {
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
    public void loginWithValidCredentialsTest(){
        AuthenticationPage authenticationPage = new AuthenticationPage();
        AuthenticationPageSteps.Authorize(authenticationPage, USERNAME, PASSWORD);
        IndexPage authorizedIndexPage = new IndexPage();
        String authorizedUsername = authorizedIndexPage.waitForUsernameLoad()
                .getUsername();

        Assert.assertEquals(authorizedUsername, USERNAME);
    }

    @Test
    public void loginWithInvalidCredentialsTest(){
        String generatedUsername = Utils.generateAlphanumericString();
        String generatedPassword = Utils.generateAlphanumericString();

        AuthenticationPage authenticationPage = new AuthenticationPage();
        AuthenticationPageSteps.Authorize(authenticationPage, generatedUsername, generatedPassword);
                authenticationPage.waitForLoginErrorMessage();

        Assert.assertTrue(authenticationPage.hasErrorMessageAppeared());
    }
}

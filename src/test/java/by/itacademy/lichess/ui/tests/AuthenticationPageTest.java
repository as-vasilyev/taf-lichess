package by.itacademy.lichess.ui.tests;

import by.itacademy.lichess.ui.driver.SingletonDriver;
import by.itacademy.lichess.ui.page.AuthenticationPage;
import by.itacademy.lichess.ui.page.IndexPage;
import by.itacademy.lichess.ui.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AuthenticationPageTest extends BaseTest {
    private final static String URL = "https://lichess.org/";
    private final static String USERNAME = "taf-test1";
    private final static String PASSWORD = "taf-test11";

    @BeforeTest
    public void BeforeTest() {
        WebDriver webDriver = SingletonDriver.getDriver();
        webDriver.get(URL);
        webDriver.manage()
                .window()
                .maximize();
        IndexPage unauthorizedIndexPage = new IndexPage();
        unauthorizedIndexPage.buttonLoginClick();
    }

    @Test
    public void loginWithValidCredentialsTest(){
        IndexPage unauthorizedIndexPage = new IndexPage();
        unauthorizedIndexPage.buttonLoginClick();

        AuthenticationPage authenticationPage = new AuthenticationPage();
        authenticationPage.typeUsername(USERNAME)
                .typePassword(PASSWORD)
                .buttonSubmitClick();
        IndexPage authorizedIndexPage = new IndexPage();
        String authorizedUsername = authorizedIndexPage.waitForPageLoad()
                .getUsername();

        Assert.assertEquals(authorizedUsername, USERNAME);
    }

    @Test
    public void loginWithInvalidCredentialsTest(){
        String generatedUsername = Utils.generateAlphanumericString();
        String generatedPassword = Utils.generateAlphanumericString();
        String expectedErrorMessage = "Invalid username or password";
        IndexPage indexPage = new IndexPage();
        indexPage.buttonLoginClick();

        AuthenticationPage authenticationPage = new AuthenticationPage();
        authenticationPage.typeUsername(generatedUsername)
                .typePassword(generatedPassword)
                .buttonSubmitClick()
                .waitForLoginErrorMessage();

        Assert.assertEquals(authenticationPage.getErrorMessageText(), expectedErrorMessage);
    }
}

package by.itacademy.lichess.ui.tests;

import by.itacademy.lichess.ui.page.AuthenticationPage;
import by.itacademy.lichess.ui.page.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPageTest {
    private final static String URL = "https://lichess.org/";
    private final static String USERNAME = "taf-test1";
    private final static String PASSWORD = "taf-test11";

    @BeforeTest
    public void BeforeTest() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(URL);
        webDriver.manage()
                .window()
                .maximize();
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
        String authorizedUsername = authorizedIndexPage.getUsername();

        Assert.AssertEquals(); //...
        //https://www.lambdatest.com/blog/most-exhaustive-xpath-locators-cheat-sheet/

    }
}

package by.itacademy.alexey_vasilyev.lichess.ui.tests;


import by.itacademy.alexey_vasilyev.lichess.ui.driver.SingletonDriver;
import by.itacademy.alexey_vasilyev.lichess.ui.page.AuthenticationPage;
import by.itacademy.alexey_vasilyev.lichess.ui.page.IndexPage;
import by.itacademy.alexey_vasilyev.lichess.ui.page.CreatedChallengePage;
import by.itacademy.alexey_vasilyev.lichess.ui.page.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IndexPageTest extends BaseTest {
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
    }

    @Test
    public void createCorrespondenceGameChallengeTest() {
        IndexPage unauthorizedIndexPage = new IndexPage();
        unauthorizedIndexPage.buttonLoginClick();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        authenticationPage.typeUsername(USERNAME)
                .typePassword(PASSWORD)
                .buttonSubmitClick();
        IndexPage authorizedIndexPage = new IndexPage();
        authorizedIndexPage.waitForPageLoad();

        authorizedIndexPage.buttonCreateFriendGameClick()
                .waitForModalCreateGameLoad()
                .selectGameType("standard")
                .selectTimeVariation("correspondence")
                .setTimeValue("2")
                .clickButtonCasualMode()
                .clickButtonWhiteSide();

        CreatedChallengePage createdChallengePage = new CreatedChallengePage();
        createdChallengePage.waitForPageLoad();
        String gameURL = createdChallengePage.getChallengeLink();
        Assert.assertNotEquals(gameURL, null);
    }

    @Test
    public void getUserProfileTest() {
        String searchedUser = "taf-test2";

        IndexPage indexPage = new IndexPage();
        indexPage.linkSearchUserClick()
                .typeSearchedUserName(searchedUser)
                .linkProfilePageClick(searchedUser);

        ProfilePage profilePage = new ProfilePage();
        String profileName = profilePage.getUsername();
        Assert.assertEquals(profileName, searchedUser);
    }
}

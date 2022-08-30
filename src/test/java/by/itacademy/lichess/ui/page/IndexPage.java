package by.itacademy.lichess.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class IndexPage extends BasePage {

    @FindBy(xpath = "//h1[@class='site-title']")
    private WebElement websiteTitle;
    @FindBy(xpath = "//a[@class='signin button button-empty']")
    private WebElement buttonLogin;
    @FindBy(xpath = "//a[@id='user_tag']")
    private WebElement linkUser;
    @FindBy(xpath = "//a[@class='button button-metal config_friend']")
    private WebElement buttonCreateGame;
    @FindBy(xpath = "//div[@class='game-setup']")
    private WebElement modalCreateGame;
    @FindBy(xpath = "//select[@id='sf_variant']")
    private WebElement selectGameVariation;
    @FindBy(xpath = "//select[@id='sf_timeMode']")
    private WebElement selectTimeControl;
    @FindBy(xpath = "//div[@class='days-choice range']//input[@class='range']")
    private WebElement inputDaysPerMove;
    @FindBy(xpath = "//label[@for='sf_mode_casual']")
    private WebElement buttonCasualMode;
    @FindBy(xpath = "//label[@for='sf_mode_rated']")
    private WebElement buttonRatedMode;
    @FindBy(xpath = "//button[@value='random']")
    private WebElement buttonPlayForRandomSide;
    @FindBy(xpath = "//button[@value='white']")
    private WebElement buttonPlayForWhiteSide;
    @FindBy(xpath = "//button[@value='black']")
    private WebElement buttonPlayForBlackSide;
    @FindBy(xpath = "//div[@class='tabs-horiz']//span[3]")
    private WebElement tabCorrespondenceGames;
    @FindBy(xpath = "//div[@id='clinput']//a")
    private WebElement linkSearchUser;
    @FindBy(xpath = "//div[@id='clinput']//input")
    private WebElement inputSearchUser;
    @FindBy(xpath = "//div[@class='complete-list']")
    private WebElement divSearchResult;
    private WebElement linkUserPage;


    public void buttonLoginClick(){
        buttonLogin.click();
    }

    public IndexPage buttonCreateFriendGameClick(){
        buttonCreateGame.click();
        return this;
    }

    public IndexPage waitForUsernameLoad(){
        waitForVisibilityOfElement(linkUser);
        return this;
    }

    public String getUsername(){
        return linkUser.getText();
    }

    public IndexPage selectGameType(String optionValue){
        Select selectGameType = new Select(selectGameVariation);
        selectGameType.selectByValue(optionValue);
        return this;
    }

    public IndexPage selectTimeVariation(String optionValue){
        Select selectTimeVariation = new Select(selectTimeControl);
        selectTimeVariation.selectByValue(optionValue);
        return this;
    }

    public IndexPage setTimeValue(String value){
        setElementAttributeByClass("range","value", value);
        return this;
    }

    public IndexPage clickButtonCasualMode(){
        buttonCasualMode.click();
        return this;
    }

    public void clickButtonRandomSide(){
        buttonPlayForRandomSide.click();
    }
    public void clickButtonWhiteSide(){
        buttonPlayForWhiteSide.click();
    }
    public void clickButtonBlackSide(){
        buttonPlayForBlackSide.click();
    }

    public IndexPage waitForModalCreateGameLoad(){
        waitForVisibilityOfElement(modalCreateGame);
        return this;
    }

    public IndexPage linkSearchUserClick(){
        linkSearchUser.click();
        return this;
    }

    public IndexPage typeSearchedUserName(String username) {

        waitForVisibilityOfElement(inputSearchUser);
        inputSearchUser.clear();
        inputSearchUser.click();
        inputSearchUser.sendKeys(username);
        waitForVisibilityOfElement(divSearchResult);
        return this;
    }

    public void linkProfilePageClick(String username){
        By xpathSearchedUserLink = By.xpath(String.format("//a[@href='/@/%s']", username));
        linkUserPage = driver.findElement(xpathSearchedUserLink);
        waitForVisibilityOfElement(linkUserPage);
        linkUserPage.click();
    }
}
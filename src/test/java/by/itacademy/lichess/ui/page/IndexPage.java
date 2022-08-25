package by.itacademy.lichess.ui.page;

import org.openqa.selenium.JavascriptExecutor;
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
    private WebElement buttonPlayWithFriend;
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

    public void buttonLoginClick(){
        buttonLogin.click();
    }

    public void buttonCreateGameWithFriend(){
        buttonPlayWithFriend.click();
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

    public IndexPage clickButtonRandomSide(){
        buttonPlayForRandomSide.click();
        return this;
    }

    public IndexPage waitForModalCreateGameLoad(){
        waitForVisibilityOfElement(modalCreateGame);
        return this;
    }
}

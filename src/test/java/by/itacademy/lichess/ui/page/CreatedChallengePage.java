package by.itacademy.lichess.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatedChallengePage extends BasePage {
    @FindBy(xpath = "//input[@id='challenge-id']")
    private WebElement inputChallengeLink;

    public String getChallengeLink(){
        waitForVisibilityOfElement(inputChallengeLink);
        return inputChallengeLink.getAttribute("value");
    }
}

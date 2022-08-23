package by.itacademy.lichess.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailCheckPage extends BasePage {
    @FindBy(xpath = "//div[@id='email-confirm']")
    private WebElement divConfirmEmail;

    public boolean hasDivConfirmEmailBeenShown = waitForVisibilityOfElement(divConfirmEmail).isDisplayed();
}

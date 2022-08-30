package by.itacademy.lichess.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
    @FindBy(xpath = "//span[contains(@class,'user-link')]")
    private WebElement spanUsername;


    public String  getUsername(){
        waitForVisibilityOfElement(spanUsername);
        return spanUsername.getText();
    }
}

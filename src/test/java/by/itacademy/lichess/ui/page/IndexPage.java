package by.itacademy.lichess.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage {
    @FindBy(xpath = "//a[@class='signin button button-empty']")
    private WebElement buttonLogin;
    @FindBy(xpath = "//a[@class='user-tag']")
    private WebElement linkUser;
    @FindBy(xpath = "//div[@class='lobby__start']//a[text()='Create a game']")
    private WebElement buttonNewGame;

    public IndexPage buttonLoginClick(){
        buttonLogin.click();
        return this;
    }

    public String getUsername(){
        return linkUser.getText();
    }
}

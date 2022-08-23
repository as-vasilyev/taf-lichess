package by.itacademy.lichess.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class IndexPage extends BasePage {
    @FindBy(xpath = "//a[@class='signin button button-empty']")
    private WebElement buttonLogin;
    @FindBy(xpath = "//a[@id='user_tag']")
    private WebElement linkUser;
    @FindBy(xpath = "//div[@class='lobby__start']//a[text()='Create a game']")
    private WebElement buttonNewGame;

    public void buttonLoginClick(){
        buttonLogin.click();
    }

    public IndexPage waitForPageLoad(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return this;
    }

    public String getUsername(){
        return linkUser.getText();
    }
}

package by.itacademy.lichess.ui.page;

import by.itacademy.lichess.ui.driver.SingletonDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected final String URL = "https://lichess.org";

    protected BasePage(){
        driver = SingletonDriver.getDriver();
        PageFactory.initElements(driver, this);
    }
}

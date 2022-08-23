package by.itacademy.lichess.ui.page;

import by.itacademy.lichess.ui.driver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected final int WAIT_TIMEOUT_SECONDS = 5;
    protected WebDriver driver = SingletonDriver.getDriver();
    protected BasePage(){
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitForVisibilityOfElement(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected WebElement waitForVisibilityOfElement(By webElementLocator) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(webElementLocator));
    }
}

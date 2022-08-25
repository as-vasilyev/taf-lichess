package by.itacademy.lichess.ui.page;

import by.itacademy.lichess.ui.driver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected final Duration WAIT_TIME = Duration.ofSeconds(5);
    protected WebDriver driver = SingletonDriver.getDriver();
    protected BasePage(){
        PageFactory.initElements(driver, this);
    }

    protected void setElementAttributeById(String elementId, String attribute, String value){
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        String script = String.format("document.getElementByID(%s).setAttribute('%s','%s')", elementId, attribute, value);
        jsExecutor.executeScript(script);
    }
    protected void setElementAttributeByClass(String className, String attribute, String value){
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        String script = String.format("document.getElementsByClassName('%s')[0].setAttribute('%s','%s')", className, attribute, value);
        jsExecutor.executeScript(script);
    }

    protected WebElement waitForVisibilityOfElement(WebElement element) {
        new WebDriverWait(driver, WAIT_TIME)
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected WebElement waitForVisibilityOfElement(By webElementLocator) {
        return new WebDriverWait(driver, WAIT_TIME)
                .until(ExpectedConditions.visibilityOfElementLocated(webElementLocator));
    }
}

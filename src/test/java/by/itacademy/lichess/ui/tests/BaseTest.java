package by.itacademy.lichess.ui.tests;

import by.itacademy.lichess.ui.driver.SingletonDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public abstract class BaseTest {
    @AfterMethod
    public void finishTest() {
        SingletonDriver.closeDriver();
    }
}

package by.itacademy.lichess.ui.tests;

import by.itacademy.lichess.ui.driver.SingletonDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    protected final static String URL = "https://lichess.org/";
    protected final static String USERNAME = "taf-test1";
    protected final static String PASSWORD = "taf-test11";

    @AfterMethod
    public void finishTest() {
        SingletonDriver.closeDriver();
    }
}

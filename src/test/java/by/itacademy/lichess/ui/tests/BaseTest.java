package by.itacademy.lichess.ui.tests;

import by.itacademy.lichess.ui.driver.SingletonDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    @AfterMethod
    public void finishTest() {
        SingletonDriver.closeDriver();
    }
}

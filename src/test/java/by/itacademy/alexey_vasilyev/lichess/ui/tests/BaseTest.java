package by.itacademy.alexey_vasilyev.lichess.ui.tests;

import by.itacademy.alexey_vasilyev.lichess.ui.driver.SingletonDriver;
import org.testng.annotations.AfterMethod;

public abstract class BaseTest {
    protected final static String URL = "https://lichess.org/";
    protected final static String USERNAME = "taf-test1";
    protected final static String PASSWORD = "taf-test11";

    @AfterMethod
    public void finishTest() {
        SingletonDriver.closeDriver();
    }
}

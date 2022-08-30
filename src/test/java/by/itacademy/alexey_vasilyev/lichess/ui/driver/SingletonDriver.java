package by.itacademy.alexey_vasilyev.lichess.ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonDriver {
    private static WebDriver driver;
    private SingletonDriver(){}

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager
                    .chromedriver()
                    .setup();
            driver = new ChromeDriver();
            driver.manage()
                    .window()
                    .maximize();
        }

        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}

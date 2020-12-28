package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Browser {

    public static WebDriver driver;

    /**
     * Method to set up a Chrome browser
     */
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/Lina/drivers/chromedriver");
        driver = new ChromeDriver();
        Browser.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * Method to quit the the browser
     */
    public static void quit() {
        driver.quit();
    }
}

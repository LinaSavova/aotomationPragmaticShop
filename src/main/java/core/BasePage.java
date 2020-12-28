package core;

import org.openqa.selenium.By;
import utils.Browser;

/**
 * Class that contains methods to deal with objects
 */
public class BasePage {

    protected static void find(By locator){
        Browser.driver.findElement(locator);
    }

    protected static void type(By locator, String whatToType){
        Browser.driver.findElement(locator).sendKeys(whatToType);
    }

    protected static void click(By locator){
        Browser.driver.findElement(locator).click();
    }

    protected static void clear(By locator){
        Browser.driver.findElement(locator).clear();
    }

    protected static String getText(By locator){
        return Browser.driver.findElement(locator).getText().trim();
    }
}

package pages.frontend;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Browser;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class Cart extends BasePage {

    private static final By FIRST_NAME_CHECKOUT_FORM = By.id("input-payment-firstname");
    private static final By LAST_NAME_CHECKOUT_FORM = By.id("input-payment-lastname");
    private static final By COMPANY_CHECKOUT_FORM = By.id("input-payment-company");
    private static final By ADDRESS_CHECKOUT_FORM = By.id("input-payment-address-1");
    private static final By CITY_CHECKOUT_FORM = By.id("input-payment-city");
    private static final By POSTCODE_CHECKOUT_FORM = By.id("input-payment-postcode");
    private static final By DROPDOWN_COUNTRIES = By.id("input-payment-country");
    private static final By DROPDOWN_REGIONS = By.id("input-payment-zone");
    private static final By CONTINUE_BUTTON = By.id("button-payment-address");
    private static final By SHOPPING_CART_PAGE_TITLE = By.cssSelector("#content h1");
    private static final By CONTINUE_BUTTON_SECOND = By.id("button-shipping-address");
    private static final By FORM_TO_FILL = By.cssSelector(".form-control");
    private static final By CONTINUE_BUTTON_THIRD = By.id("button-shipping-method");
    private static final By AGREE_TOS = By.name("agree");
    private static final By CONTINUE_BUTTON_FOURTH = By.id("button-payment-method");
    private static final By CONFIRM_ORDER_BUTTON = By.id("button-confirm");
    private static final By CONFIRMATION_MESSAGE_ORDER = By.xpath("//div[@id='content']/h1");

    /**
     * Verify that a page title appears when user goes to Cart
     * @param expectedMessage the title we expect to see when go to Cart
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyPageTitle(String expectedMessage, String messageOnFailure) {
        String actualMessage = getText(SHOPPING_CART_PAGE_TITLE);
        assertTrue(actualMessage.contains(expectedMessage), messageOnFailure);
    }

    public static void orderAnItemForFirstTime(String firstName, String lastName, String company, String address1,
                                   String city, String postcode, String comment) {
        type(FIRST_NAME_CHECKOUT_FORM, firstName);
        type(LAST_NAME_CHECKOUT_FORM, lastName);
        type(COMPANY_CHECKOUT_FORM, company);
        type(ADDRESS_CHECKOUT_FORM, address1);
        type(CITY_CHECKOUT_FORM, city);
        type(POSTCODE_CHECKOUT_FORM, postcode);

        WebElement dropdown = Browser.driver.findElement(DROPDOWN_COUNTRIES);
        Select country = new Select(dropdown);
        List<WebElement> allOptions = country.getOptions();
        for (WebElement allOption : allOptions) {
            country.selectByValue("33"); //Bulgaria
        }

        WebElement dropdown2 = Browser.driver.findElement(DROPDOWN_REGIONS);
        click(DROPDOWN_COUNTRIES);
        Select region = new Select(dropdown2);
        region.selectByValue("498"); //Sofia-town

        click(CONTINUE_BUTTON);
        click(CONTINUE_BUTTON_SECOND);
        type(FORM_TO_FILL, comment);
        click(CONTINUE_BUTTON_THIRD);
        WebElement checkboxTOS = Browser.driver.findElement(AGREE_TOS);
        if(!checkboxTOS.isSelected()){
            checkboxTOS.click();
        }
        click(CONTINUE_BUTTON_FOURTH);
        click(CONFIRM_ORDER_BUTTON);
    }

    public static void orderItems(String comment) {
        click(CONTINUE_BUTTON);
        click(CONTINUE_BUTTON_SECOND);
        type(FORM_TO_FILL, comment);
        click(CONTINUE_BUTTON_THIRD);
        WebElement checkboxTOS = Browser.driver.findElement(AGREE_TOS);
        if(!checkboxTOS.isSelected()){
            checkboxTOS.click();
        }
        click(CONTINUE_BUTTON_FOURTH);
        click(CONFIRM_ORDER_BUTTON);
    }

    public static void verifyItemOrderedMessage(String expectedMessage, String messageOnFailure) {
        Wait<WebDriver> wait = new WebDriverWait(Browser.driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(CONFIRMATION_MESSAGE_ORDER, "Your order has been placed!"));
        String actualMessage = getText(CONFIRMATION_MESSAGE_ORDER);
        assertEquals(actualMessage, expectedMessage, messageOnFailure);
    }
}

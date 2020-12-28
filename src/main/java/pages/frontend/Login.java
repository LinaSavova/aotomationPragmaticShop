package pages.frontend;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Browser;
import static org.testng.Assert.*;

public class Login extends BasePage {

    private static final By MY_ACCOUNT_DROPDOWN = By.cssSelector("#top-links .dropdown .hidden-sm");
    private static final By REGISTER_BUTTON = By.xpath(".//*[contains(text(),'Register')]");
    private static final By FIRST_NAME_INPUT = By.id("input-firstname");
    private static final By LAST_NAME_INPUT = By.id("input-lastname");
    private static final By EMAIL_INPUT = By.id("input-email");
    private static final By PHONE_INPUT = By.id("input-telephone");
    private static final By PASSWORD_INPUT = By.id("input-password");
    private static final By CONFIRM_PASSWORD_INPUT = By.id("input-confirm");
    private static final By AGREE_CHECKBOX = By.name("agree");
    private static final By CONTINUE_BUTTON = By.cssSelector(".btn-primary");
    private static final By LOGIN_BUTTON = By.xpath(".//*[contains(text(),'Login')]");
    private static final By LOGIN_EMAIL_INPUT = By.id("input-email");
    private static final By LOGIN_PASSWORD_INPUT = By.id("input-password");
    private static final By REGISTERED_LOGIN_BUTTON = By.xpath("//input[@class='btn btn-primary']");
    private static final By LOGIN_NO_MATCH_MESSAGE = By.className("alert-dismissible");
    private static final By LOGOUT_TITLE = By.cssSelector("#content h1");

    /**
     * Opens the area of shop.pragmatic.bg
     */
    public static void goTo() {
        Browser.driver.get("http://shop.pragmatic.bg/");
        Browser.driver.manage().window().maximize();
    }

    /**
     * Register a brand new user
     * @param firstName first name of the user
     * @param lastName last name of the user
     * @param email email of the user
     * @param phone telephone of the user
     * @param password account's password
     */
    public static void makeNewRegistration(String firstName, String lastName, String email,
                                           String phone, String password) {
        click(MY_ACCOUNT_DROPDOWN);
        click(REGISTER_BUTTON);
        type(FIRST_NAME_INPUT, firstName);
        type(LAST_NAME_INPUT, lastName);
        type(EMAIL_INPUT, email);
        type(PHONE_INPUT, phone);
        type(PASSWORD_INPUT, password);
        type(CONFIRM_PASSWORD_INPUT, password);
        WebElement checkbox = Browser.driver.findElement(AGREE_CHECKBOX);
        if(!checkbox.isSelected()){
            checkbox.click();
        }
        click(CONTINUE_BUTTON);
    }

    /**
     * Login with right credentials
     * @param email the email of a registered user
     * @param password the password for login to that site
     */
    public static void login(String email, String password) {
        click(MY_ACCOUNT_DROPDOWN);
        click(LOGIN_BUTTON);
        type(LOGIN_EMAIL_INPUT, email);
        type(LOGIN_PASSWORD_INPUT, password);
        click(REGISTERED_LOGIN_BUTTON);
    }

    /**
     * Verify the right validation message to appear when user tries to login with wrong credentials
     * @param expectedMessage the validation message that should appear when wrong credentials are entered
     * @param messageOnFailure the message that will appear in case of test failure in our reports
     */
    public static void verifyValidationMessage(String expectedMessage, String messageOnFailure) {
        String actualMessage = getText(LOGIN_NO_MATCH_MESSAGE);
        assertEquals(actualMessage, expectedMessage, messageOnFailure);
    }

    /**
     * Verify proper page title to appear when user is logged out
     * @param expectedMessage the message user should see when logout
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyPageTitle(String expectedMessage, String messageOnFailure) {
        String actualMessage = getText(LOGOUT_TITLE);
        assertEquals(actualMessage, expectedMessage, messageOnFailure);
    }
}

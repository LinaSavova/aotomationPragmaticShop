package pages.backend;

import core.BasePage;
import org.openqa.selenium.By;
import utils.Browser;
import static org.testng.Assert.*;

/**
 * A Page Class that represents the Admin login page of shop.pragmatic.bg/admin
 */
public class AdminLogin extends BasePage {

    private static final By USERNAME_INPUT_FIELD = By.id("input-username");
    private static final By PASSWORD_INPUT_FIELD = By.id("input-password");
    private static final By LOGIN_BUTTON = By.cssSelector(".btn.btn-primary");
    private static final By VALIDATION_MESSAGE = By.cssSelector(".alert-danger");

    /**
     * Opens the admin area of shop.pragmatic.bg/admin
     */
    public static void goTo() {
        Browser.driver.get("http://shop.pragmatic.bg/admin/");
    }

    /**
     * Logs into the admin area of shop.pragmatic.bg/admin using the provided credentials
     * @param username the username you would like to login with
     * @param password the password you would like to login with
     */
    public static void logIn(String username, String password) {
        type(USERNAME_INPUT_FIELD, username);
        type(PASSWORD_INPUT_FIELD, password);
        click(LOGIN_BUTTON);
    }

    /**
     * Verify that the right message is appearing when user put wrong credentials
     * @param expectedMessage the message we expect to see when wrong credentials are entered
     * @param messageOnFailure the message that will appear in case of test failure in our reports
     */
    public static void verifyValidationMessage(String expectedMessage, String messageOnFailure) {
        String actualMessage = getText(VALIDATION_MESSAGE);
        assertTrue(actualMessage.contains(expectedMessage), messageOnFailure);

    }
}

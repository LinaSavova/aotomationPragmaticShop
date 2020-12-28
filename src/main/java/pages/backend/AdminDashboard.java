package pages.backend;

import org.openqa.selenium.By;
import utils.Browser;
import static org.testng.Assert.*;

/**
 * Opens the admin dashboard
 */
public class AdminDashboard {

    private static final By LOGOUT_MENU = By.className("hidden-xs");

    /**
     * Verify if the title of the logout menu is present for a logged in user
     * @param expectedLogoutTitle the logout title we expect to be on the dashboard page
     * @param messageOnFailure the message that will appear in case of test failure in our reports
     */
    public static void verifyLogOutButton(String expectedLogoutTitle, String messageOnFailure) {
        String actualLogoutTitle = Browser.driver.findElement(LOGOUT_MENU).getText().trim();
        assertEquals(actualLogoutTitle, expectedLogoutTitle, messageOnFailure);
    }
}

package pages.frontend;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Browser;

import java.util.List;

import static org.testng.Assert.*;

public class Home extends BasePage {

    private static final By REGISTRATION_CONFIRMATION_MESSAGE = By.cssSelector("#content h1");
    private static final By CONTINUE_BUTTON = By.cssSelector(".row .buttons a");
    private static final By MY_ACCOUNT_HEAD = By.cssSelector("#content h2:nth-of-type(1)");
    private static final By MY_ACCOUNT_DROPDOWN = By.cssSelector("#top-links .dropdown .hidden-sm");
    private static final By LOGOUT_BUTTON = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li[5]");
    private static final By SEARCH_FIELD_INPUT = By.cssSelector("#search input");
    private static final By SEARCH_ICON = By.cssSelector(".btn.btn-default.btn-lg");
    private static final By PRODUCT_NOT_FOUND_MESSAGE = By.cssSelector(".row p:nth-of-type(2)");
    private static final By PRODUCT_FOUND_MESSAGE = By.cssSelector(".row h2");
    private static final By ADD_TO_CART_BUTTON = By.xpath("//div[@class='button-group']//span[1]"); //returns a COLLECTION if there are more than one items
    private static final By SUCCESS_ALERT_ITEM_ADDED = By.cssSelector(".alert-success");
    private static final By WISHLIST_UPPER_MENU = By.id("wishlist-total");
    private static final By ADD_TO_WISHLIST_BUTTON = By.cssSelector(".button-group .fa-heart"); //returns a Collection if there are more than one items
    private static final By REMOVE_FROM_WISHLIST_BUTTON = By.cssSelector(".text-right i.fa.fa-times");
    private static final By EMPTY_WISHLIST_MESSAGE = By.cssSelector("#content p");
    private static final By SHOPPING_CART_UPPER_MENU = By.xpath("//ul[@class='list-inline']/li[4]/a/span");
    private static final By REMOVE_FROM_CART_BUTTON = By.cssSelector(".text-left .btn.btn-danger");
    private static final By EMPTY_CART_MESSAGE = By.cssSelector(".col-sm-12 p");
    private static final By CHECKOUT_UPPER_MENU = By.xpath("//ul[@class='list-inline']//li[5]//a//span");
    private static final By CART_BUTTON = By.id("cart");
    private static final By VIEW_CART_BUTTON = By.cssSelector(".dropdown-menu.pull-right li:nth-of-type(2) a:nth-of-type(1)");


    /**
     * Verify a confirmation message is appearing if the registration is successful
     */
    public static void verifySuccessfulLoginMessage(String expectedMessage, String messageOnFailure) {
        String actualMessage = getText(REGISTRATION_CONFIRMATION_MESSAGE);
        assertEquals(actualMessage, expectedMessage, messageOnFailure);
        click(CONTINUE_BUTTON);
    }

    /**
     * Verify that user sees an account head after successful registration in his profile
     * @param expectedMessage head title that we expect to see
     * @param messageOnFailure message to appear in case of failure
     */
    public static void verifyMyAccountTitle(String expectedMessage, String messageOnFailure){
        String actualMessage = getText(MY_ACCOUNT_HEAD);
        assertEquals(actualMessage, expectedMessage, messageOnFailure);
    }

    /**
     * Logout from the account
     */
    public static void logout() {
        click(MY_ACCOUNT_DROPDOWN);
        click(LOGOUT_BUTTON);
    }

    /**
     * Search for items
     * @param item the name of the product user should enter into the search field
     */
    public static void search(String item) {
        type(SEARCH_FIELD_INPUT, item);
        click(SEARCH_ICON);
    }

    /**
     * Verify the correct validation message when there is no such a product
     * @param expectedMessage the message user should see when the item is not found
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyMessageUnsuccessfulSearch(String expectedMessage, String messageOnFailure) {
        String actualMessage = getText(PRODUCT_NOT_FOUND_MESSAGE);
        assertEquals(actualMessage, expectedMessage, messageOnFailure);
    }

    /**
     * Verify that there is a message when items searched are found
     * @param expectedMessage the message that user should see when an item is found
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyMessageSuccessfulSearch(String expectedMessage, String messageOnFailure) {
        String actualMessage = getText(PRODUCT_FOUND_MESSAGE);
        assertEquals(actualMessage, expectedMessage, messageOnFailure);
    }

    /**
     * Add an item in your Cart
     */
    public static void addToCart() {
        List<WebElement> buttonsAddItem = Browser.driver.findElements(ADD_TO_CART_BUTTON);
        buttonsAddItem.get(0).click();
        Browser.driver.navigate().refresh();
    }

    /**
     * Verify that there is a success message after an item is added to the cart
     * @param expectedMessage the message we expect to see when an item is added to the cart
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyCartIncreased(String expectedMessage, String messageOnFailure) {
        String actualMessage = getText(SUCCESS_ALERT_ITEM_ADDED);
        assertTrue(actualMessage.contains(expectedMessage), messageOnFailure);
    }

    /**
     * Add an item to Wish List and verify that Wish List count changes
     * @param item name of an item to find
     * @param messageOnFailure the message that should appear in case of failure on our reports
     */
    public static void addToWishList(String item, String messageOnFailure) {
        String wishlistCount = getText(WISHLIST_UPPER_MENU);
        System.out.println("Current wishlist count: " + wishlistCount);

        type(SEARCH_FIELD_INPUT, item);
        click(SEARCH_ICON);
        List<WebElement> wishlistButtons = Browser.driver.findElements(ADD_TO_WISHLIST_BUTTON);
        wishlistButtons.get(0).click();
        Browser.driver.navigate().refresh();

        String wishlistCountAfterItemAdded = getText(WISHLIST_UPPER_MENU);
        System.out.println("Wishlist count after item is added: " + wishlistCountAfterItemAdded);
        assertFalse(wishlistCountAfterItemAdded.matches(wishlistCount), messageOnFailure);
    }

    /**
     * Empty the Wish List
     */
    public static void emptyWishlist() {
        click(WISHLIST_UPPER_MENU);
        click(REMOVE_FROM_WISHLIST_BUTTON);
    }

    /**
     * Verify that a proper message appears after user clears his Wish List
     * @param expectedMessage the message that we expect to see if Wish List is empty
     * @param messageOnFailure the messahe that should appear in case of failure in our reports
     */
    public static void verifyEmptyWishlistMessage(String expectedMessage, String messageOnFailure) {
        String actualMessage = getText(EMPTY_WISHLIST_MESSAGE);
        assertEquals(actualMessage, expectedMessage, messageOnFailure);
    }

    /**
     * Go to Cart from upper menu
     */
    public static void goToCart() {
        click(SHOPPING_CART_UPPER_MENU);
    }

    /**
     * Remove an item from the Cart and empty it
     */
    public static void emptyCart() {
        click(SHOPPING_CART_UPPER_MENU);
        click(REMOVE_FROM_CART_BUTTON);
        Browser.driver.navigate().refresh();
    }

    /**
     * Verify that the right message appears when the Cart is empty
     * @param expectedMessage the message that should appear on the screen
     * @param messageOnFailure the message that should appear in case of failure in our reports
     */
    public static void verifyEmptyCartMessage(String expectedMessage, String messageOnFailure) {
        String actualMessage = getText(EMPTY_CART_MESSAGE);
        assertEquals(actualMessage, expectedMessage, messageOnFailure);
    }

    /**
     * Go to Checkout upper menu
     */
    public static void goToCheckout() {
        click(CHECKOUT_UPPER_MENU);
    }

    /**
     * Go to Cart from the button
     */
    public static void viewCart() {
        click(CART_BUTTON);
        click(VIEW_CART_BUTTON);
    }
}

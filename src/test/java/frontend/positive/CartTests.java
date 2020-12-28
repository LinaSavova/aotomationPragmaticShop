package frontend.positive;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Cart;
import pages.frontend.Home;
import pages.frontend.Login;

public class CartTests extends BaseTests {

    @Test
    public void goToCart() {
        Login.goTo();
        Login.login("clucking@motorvationist.com", "1234567");
        Home.goToCart();
        Cart.verifyPageTitle("Shopping Cart", "User is not into Cart");
    }

    @Test
    public void addToCart() {
        Login.goTo();
        Login.login("clucking@motorvationist.com", "1234567");
        Home.search("mac");
        Home.addToCart();
        Home.verifyCartIncreased("Success: You have added", "Item is not added to the cart");
    }

    @Test
    public void emptyCart() {
        Login.goTo();
        Login.login("clucking@motorvationist.com", "1234567");
        Home.emptyCart();
        Home.verifyEmptyCartMessage("Your shopping cart is empty!", "Cart is not empty!");
    }

    @Test
    public void orderAnItemWithNoCredentialsEntered() {
        Login.goTo();
        Login.login("clucking@motorvationist.com", "1234567");
        Home.search("mac");
        Home.addToCart();
        Home.goToCart();
        Cart.orderAnItemForFirstTime("Test", "Testov", "Testonia", "Testng 27", "Sofia", "1000", "test");
        Cart.verifyItemOrderedMessage("Your order has been placed!", "Order not proceeded!");
    }

    @Test
    public void orderAnItemWithCredentialsEntered() {
        Login.goTo();
        Login.login("clucking@motorvationist.com", "1234567");
        Home.search("mac");
        Home.addToCart();
        Home.goToCheckout();
        Cart.orderItems("test");
        Cart.verifyItemOrderedMessage("Your order has been placed!", "Order not proceeded!");
    }

    @Test
    public void viewCartFromButton(){
        Login.goTo();
        Login.login("clucking@motorvationist.com", "1234567");
        Home.viewCart();
        Cart.verifyPageTitle("Shopping Cart", "User is not into Cart");
    }
}

package frontend.positive;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Home;
import pages.frontend.Login;

public class WishListTests extends BaseTests {

    @Test
    public void successfulAddToWishList(){
        Login.goTo();
        Login.login("clucking@motorvationist.com", "1234567");
        Home.addToWishList("apple", "Wishlist count does not change after an item is added");
        //Verification is into the method itself
    }

    @Test
    public void emptyWishlist(){
        Login.goTo();
        Login.login("clucking@motorvationist.com", "1234567");
        Home.emptyWishlist();
        Home.verifyEmptyWishlistMessage("Your wish list is empty.", "");
    }
}

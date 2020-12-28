package frontend.negative;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Home;
import pages.frontend.Login;

public class SearchTest extends BaseTests {

    @Test
    public void unsuccessfulSearch(){
        Login.goTo();
        Login.login("clucking@motorvationist.com", "1234567");
        Home.search("maccho");
        Home.verifyMessageUnsuccessfulSearch("There is no product that matches the search criteria.", "No validation message");
    }
}

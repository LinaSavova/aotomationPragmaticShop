package frontend.positive;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Home;
import pages.frontend.Login;

public class SearchTests extends BaseTests {

    @Test
    public void successfulSearch(){
        Login.goTo();
        Login.login("clucking@motorvationist.com", "1234567");
        Home.search("mac");
        Home.verifyMessageSuccessfulSearch("Products meeting the search criteria", "Missing confirmation message");
    }
}

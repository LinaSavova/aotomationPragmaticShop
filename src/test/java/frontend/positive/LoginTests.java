package frontend.positive;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Home;
import pages.frontend.Login;

public class LoginTests extends BaseTests {

    @Test
    public void successfullogin(){
        Login.goTo();
        Login.login("clucking@motorvationist.com", "1234567");
        Home.verifyMyAccountTitle("My Account", "No Header for logged in users");
    }
}

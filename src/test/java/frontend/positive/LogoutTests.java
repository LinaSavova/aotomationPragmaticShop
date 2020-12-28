package frontend.positive;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Home;
import pages.frontend.Login;

public class LogoutTests extends BaseTests {

    @Test
    public void successfulLogout(){
        Login.goTo();
        Login.login("clucking@motorvationist.com", "1234567");
        Home.logout();
        Login.verifyPageTitle("Account Logout", "Bug in logout");

    }
}

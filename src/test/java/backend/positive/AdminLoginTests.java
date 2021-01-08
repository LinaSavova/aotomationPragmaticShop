package backend.positive;

import core.BaseTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.backend.AdminDashboard;
import pages.backend.AdminLogin;
import utils.Browser;

public class AdminLoginTests extends BaseTests {

    @Test
    public void successfulLogin(){
        AdminLogin.goTo();
        AdminLogin.logIn("putUsernameHere", "putPasswordHere");
        AdminDashboard.verifyLogOutButton("Logout", "Logout title not as expected to be");
    }

}

package backend.negative;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.backend.AdminLogin;

public class AdminLoginTests extends BaseTests {

    @Test
    public void unsuccessfulLoginWrongCredentials(){
        AdminLogin.goTo();
        AdminLogin.logIn("admincho", "passs1234");
        AdminLogin.verifyValidationMessage("No match for Username and/or Password.", "Validation message not present or wrong");
    }

}

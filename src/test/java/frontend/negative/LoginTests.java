package frontend.negative;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Login;

public class LoginTests extends BaseTests {

    @Test
    public void unsuccessfulLogin() {
        Login.goTo();
        Login.login("clucking@motorvationist.com", "1234567890");
        Login.verifyValidationMessage("Warning: No match for E-Mail Address and/or Password.", "No validation message");
    }
}

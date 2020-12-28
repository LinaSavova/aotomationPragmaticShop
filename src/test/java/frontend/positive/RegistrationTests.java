package frontend.positive;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Home;
import pages.frontend.Login;

public class RegistrationTests extends BaseTests {

    @Test
    public void Register(){
        Login.goTo();
        Login.makeNewRegistration("Kosta", "Kostov", "kostata34@abv.bg", "0876123123", "1234567890");
        Home.verifySuccessfulLoginMessage("Your Account Has Been Created!", "Not a proper confirmation message");
        Home.verifyMyAccountTitle("My Account", "Not a proper header message");
    }
}

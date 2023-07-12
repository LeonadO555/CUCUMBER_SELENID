package steps;

import pages.HomePage;
import pages.LoginPage;

public class BaseSteps {
    LoginPage loginPage = new LoginPage();
    RegistrationPage registrationPage = new RegistrationPage();
    HomePage homePage = new HomePage();
}

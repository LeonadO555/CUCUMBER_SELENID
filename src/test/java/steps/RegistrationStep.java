package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.github.javafaker.Faker;

public class RegistrationStep extends BaseStep {
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String defaultUserName = "YouCanDeleteMe";
    String defaultPassword = "123456";

    @Given("Open main page {string}")
    public void openMainPage(String string) {
        Selenide.open(string);
    }

    @When("Click on signUpButton")
    public void clickOnSignUpButton() {
        mainPage.signUpHeaderButton.click();
    }

    @And("Select role")
    public void selectRole() {
        loginPage.selectRoleDropDown.click();
        loginPage.teacherRole.click();
    }
    @And("Fill Registration fields")
    public void fillRegistrationFields() {
        loginPage.fillField(loginPage.fullNameInput, defaultUserName);
        loginPage.fillField(loginPage.emailInput, email);
        loginPage.fillField(loginPage.passwordInput, defaultPassword);
    }
    @And("Click on checkbox: I agree to the Terms and Privacy Policy")
    public void clickOnCheckbox() {
        loginPage.checkBox.click();
    }
    @And("Click on signUp button")
    public void clickOnSignUp() {
        loginPage.signUpButton.click();
    }
    @And ("Sign Out")
    public void signOut() {
    loginPage.avatarButton.click();
    loginPage.signOutButton.click();
    }

    @Then("User logged out")
    public void checkUserLoggedOut() {
        mainPage.signUpHeaderButton.should(Condition.visible);
    }


}

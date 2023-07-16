package steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps extends BaseSteps {
    String defaultPassword = "123456";

    @When("^Click on signInButton$")
    public void clickOnSignInButton() {
        homePage.signInButton.click();
    }

    @And("^Fill email input$")
    public void fillEmailInput(){
        loginPage.emailInput.sendKeys("roxanne@example.com");
    }

    @And("^Fill password input$")
    public void fillPasswordInput(){
        loginPage.passwordInput.sendKeys(defaultPassword);
    }

    @And("^Click on Sign In button$")
    public void studentLogIn(){
        loginPage.signInButton.click();
    }

    @Then("^Check displayed Home page$")
    public void checkUserOnHomePage(){
        homePage.avatarButton.shouldBe(Condition.visible);
    }

}

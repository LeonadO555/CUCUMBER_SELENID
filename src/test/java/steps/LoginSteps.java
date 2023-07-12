package steps;


import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class LoginSteps extends BaseSteps {
    WebDriver driver;
    String email = "roxanne@example.com";
    String password = "123456";

    @When("^Fill fields valid data$")
    public void fillSingInForm() {
        loginPage.fillInput(loginPage.emailInput, email);
        loginPage.fillInput(loginPage.passwordInput, password);
    }

    @And("^Click on Login button$")
    public void clickOnSignInButton(){
        loginPage.signInButton.click();
    }

    @Then("^Check displayed Home page$")
    public void checkHomePageIsVisible(){
        homePage.addCourseButton.shouldBe(Condition.visible);
    }
}

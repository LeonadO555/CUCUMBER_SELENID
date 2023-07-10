package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;
public class SignUp extends BaseSteps{
    private WebDriver driver;
    @Given("Navigate to SignUp Page")
    public void navigateToSignUpPage(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://jere237.softr.app/sign-up");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @When("Sign Up valid data with fullName {string}, email {string}, and password {string}")
    public void fillFormSignUp(String fullName, String email, String password) {
        if (fullName.equals("RANDOM")) {
            fullName = generateRandomFullName();
        }

        if (email.equals("RANDOM")) {
            email = generateRandomEmail();
        }

        if (password.equals("RANDOM")) {
            password = generateRandomPassword();
        }

        click(signUpPage.selectRoleButton);
        click(signUpPage.selectRoleTeacher);
        fillInputSingUp(signUpPage.fullNameInput, fullName);
        fillInputSingUp(signUpPage.emailInput, email);
        fillInputSingUp(signUpPage.passwordInput, password);
        click(signUpPage.CheckboxIAgreeTerms);
    }
    private String generateRandomFullName() {
        Faker faker = new Faker();
        return faker.name().fullName();
    }
    private String generateRandomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }
    private String generateRandomPassword() {
        Faker faker = new Faker();
        return faker.internet().password();
    }
    @And("Click on Sign Up button")
    public void clickOnSignUpnButton(){
        click(signUpPage.signUpButton);
    }
    @Then("Check Displayed Error Message User Exist")
    public void checkDisplayedErrorMessagePage() {
        driver.findElement(signUpPage.userExistErrorMessage).isDisplayed();
        driver.quit();
    }
    private void fillInputSingUp(By locator, String value) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }
    private void click(By locator) {
        driver.findElement(locator).click();
    }
}

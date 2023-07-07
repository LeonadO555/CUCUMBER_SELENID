package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

public class SignUp {
    private WebDriver driver;
    Faker faker = new Faker();

    By emailField =By.xpath("//input[@placeholder='Email']");
    By passwordField =By.xpath("//input[@placeholder='Password']");
    By fullNameField =By.xpath("//input[@placeholder='Full Name']");
    By CheckboxIAgreeTerms=By.xpath("//span[@class='checkmark position-relative sw-checkbox']");
    By signUpButton =By.xpath("//a[@id='sw-sign-up-submit-btn']");
    By selectRoleButton =By.xpath("//div[@class='filter-option-inner-inner']");
    By selectRoleTeacher =By.xpath("//span[normalize-space()='teacher']");
    By addCourseText =By.xpath("//span[normalize-space()='Add course']");
    By userExistErrorMessage = By.xpath("//div[@class='error-message signup-error d-flex']");

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
        click(selectRoleButton);
        click(selectRoleTeacher);
        fillFieldSingUp(fullNameField, fullName);
        fillFieldSingUp(emailField, email);
        fillFieldSingUp(passwordField, password);
        click(CheckboxIAgreeTerms);
    }
    @And("Click on Sign Up button")
    public void clickOnSignUpnButton(){
        click(signUpButton);
    }

    @Then("Check Displayed Error Message User Exist")
    public void checkDisplayedErrorMessagePage() {
        driver.findElement(userExistErrorMessage).isDisplayed();
        driver.quit();
    }
    private void fillFieldSingUp(By locator, String value) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }
    private void click(By locator) {
        driver.findElement(locator).click();
    }

}

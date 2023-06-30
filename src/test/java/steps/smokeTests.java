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
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class smokeTests {
    private WebDriver driver;
    Faker faker = new Faker();

    By emailField =By.xpath("//input[@placeholder='Email']");
    By passwordField =By.xpath("//input[@placeholder='Password']");
    By fullNameField =By.xpath("//input[@placeholder='Full Name']");
    By CheckboxIAgreeTerms=By.xpath("//span[@class='checkmark position-relative sw-checkbox']");
    By signInButton =By.xpath("//a[@id='sw-sign-in-submit-btn']");
    By signUpButton =By.xpath("//a[@id='sw-sign-up-submit-btn']");
    By selectRoleButton =By.xpath("//div[@class='filter-option-inner-inner']");
    By selectRoleTeacher =By.xpath("//span[normalize-space()='teacher']");
    By addCourseText =By.xpath("//span[normalize-space()='Add course']");
    By invalidEmailOrPasswordErrorMessage = By.xpath("//div[@class='error-message login-error d-block']");
    By userExistErrorMessage = By.xpath("//div[@class='error-message signup-error d-flex']");

    @Given("Navigate to SingIn Page")
    public void navigateToSingInPage(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://jere237.softr.app/sign-in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Given("Navigate to SingUp Page")
    public void navigateToSingUpPage(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://jere237.softr.app/sign-up");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @When("Fill fields valid data for sing In")
    public void fillFormSingIn(){
        fillFieldValidData(emailField);
        fillFieldValidData(passwordField);
    }
    @When("User enters invalid username and password for sing In")
    public void fillFormSingInInvalid() {
        fillFieldInvalidData(emailField);
        fillFieldInvalidData(passwordField);
    }
    @When("Sing Up valid data")
    public void fillFormSingUp() {
        click(selectRoleButton);
        click(selectRoleTeacher);
        fillFieldSingUp(fullNameField);
        fillFieldSingUp(emailField);
        fillFieldSingUp(passwordField);
        click(CheckboxIAgreeTerms);
    }
    @When("Sing Up exist User")
    public void fillFormSingUpExistUser() {
        click(selectRoleButton);
        click(selectRoleTeacher);
        fillFieldSingUpExistUser(fullNameField);
        fillFieldSingUpExistUser(emailField);
        fillFieldSingUpExistUser(passwordField);
        click(CheckboxIAgreeTerms);
    }
    @And("Click on Sing In button")
    public void clickOnSingInButton(){
        click(signInButton);
    }

    @And("Click on Sing Up button")
    public void clickOnSignUpnButton(){
        click(signUpButton);
    }

    @Then("Check displayed Add Course Text")
    public void checkDisplayedAddCourseText(){
        driver.findElement(addCourseText).isDisplayed();
        driver.quit();
    }
    @Then("Check Displayed Error Message password or login")
    public void checkDisplayedErrorMessagePasswordOrEmail(){
        driver.findElement(invalidEmailOrPasswordErrorMessage).isDisplayed();
        driver.quit();
    }
    @Then("Check Displayed Error Message User Exist")
    public void checkDisplayedErrorMessagePage(){
        driver.findElement(userExistErrorMessage).isDisplayed();
        driver.quit();
    }

    private void fillFieldValidData(By locator) {
        click(locator);
        driver.findElement(locator).clear();
        if (locator.equals(emailField)) {
            driver.findElement(locator).sendKeys("roxanne@example.com");
        } else if (locator.equals(passwordField)) {
            driver.findElement(locator).sendKeys("123456");
        }
    }
    private void fillFieldInvalidData(By locator) {
        click(locator);
        driver.findElement(locator).clear();
        if (locator.equals(emailField)) {
            driver.findElement(locator).sendKeys("jeffryhamer'gmald");
        } else if (locator.equals(passwordField)) {
            driver.findElement(locator).sendKeys("1234567");
        }
    }
    private void fillFieldSingUp(By locator) {
        click(locator);
        driver.findElement(locator).clear();
         if (locator.equals(fullNameField)) {
            driver.findElement(locator).sendKeys(faker.name().name());
        } else if (locator.equals(emailField)) {
            driver.findElement(locator).sendKeys(faker.internet().emailAddress());
        } else if (locator.equals(passwordField)) {
            driver.findElement(locator).sendKeys(faker.internet().password());
        }
    }
    private void fillFieldSingUpExistUser(By locator) {
        click(locator);
        driver.findElement(locator).clear();
        if (locator.equals(fullNameField)) {
            driver.findElement(locator).sendKeys("Roxanne");
        } else if (locator.equals(emailField)) {
            driver.findElement(locator).sendKeys("roxanne@example.com");
        } else if (locator.equals(passwordField)) {
            driver.findElement(locator).sendKeys("123456");
        }
    }
    private void click(By locator) {
        driver.findElement(locator).click();
    }

}

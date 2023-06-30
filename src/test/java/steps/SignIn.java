package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import wait.Wait;

import java.util.concurrent.TimeUnit;

public class SignIn {
    private WebDriver driver;
    Wait wait;

    By emailField =By.xpath("//input[@placeholder='Email']");
    By passwordField =By.xpath("//input[@placeholder='Password']");
    By signInButton =By.xpath("//a[@id='sw-sign-in-submit-btn']");
    By addCourseText =By.xpath("//span[normalize-space()='Add course']");
    By invalidEmailOrPasswordErrorMessage = By.xpath("//div[@class='error-message login-error d-block']");



    @Given("Navigate to SingIn Page")
    public void navigateToSingInPage(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://jere237.softr.app/sign-in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @When("Fill fields valid data for Sing In")
    public void fillFormSingIn(){
        fillFieldValidData(emailField);
        fillFieldValidData(passwordField);
    }
    @When("User enters invalid username and password for Sing In")
    public void fillFormSignInInvalid() {
        fillFieldInvalidData(emailField);
        fillFieldInvalidData(passwordField);
    }
    @And("Click on Sing In button")
    public void clickOnSingInButton(){
        click(signInButton);
    }
    @Then("Check displayed Add Course Text")
    public void checkDisplayedAddCourseText() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(addCourseText).isDisplayed();
        driver.quit();
    }
    @Then("Check Displayed Error Message password or login")
    public void checkDisplayedErrorMessagePasswordOrEmail(){
        driver.findElement(invalidEmailOrPasswordErrorMessage).isDisplayed();
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
    private void click(By locator) {
        driver.findElement(locator).click();
    }

}

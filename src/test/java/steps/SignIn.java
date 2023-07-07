package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SignIn extends BaseSteps{
    private WebDriver driver;
    @Given("Navigate to SingIn Page")
    public void navigateToSignInPage(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://jere237.softr.app/sign-in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @When("Fill fields valid data for Sing In with email {string} and password {string}")
    public void fillFormSignIn(String email, String password) {
        fillFieldWithData(signInPage.emailField, email);
        fillFieldWithData(signInPage.passwordField, password);
    }
    @And("Click on Sing In button")
    public void clickOnSingInButton(){
        click(signInPage.signInButton);
    }
    @Then("Check displayed Add Course Text")
    public void checkDisplayedAddCourseText() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(signInPage.addCourseText).isDisplayed();
        driver.quit();
    }
    @Then("Check Displayed Error Message password or login")
    public void checkDisplayedErrorMessagePasswordOrEmail(){
        driver.findElement(signInPage.invalidEmailOrPasswordErrorMessage).isDisplayed();
        driver.quit();
    }

    private void fillFieldWithData(By locator, String data) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(data);
    }


    private void click(By locator) {
        driver.findElement(locator).click();
    }

}

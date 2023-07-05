package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationStep {
    private final SelenideElement signUpHeaderButton = $x("//span[normalize-space()='Sign up']");
    private final SelenideElement selectRoleDropDown = $x("//div[@class='filter-option-inner-inner']");
    private final SelenideElement teacherRole = $x("//span[normalize-space()='teacher']");
    private final SelenideElement fullNameInput = $x("//input[@id='sw-form-capture-full_name-input']");
    private final SelenideElement emailInput = $x("//input[@id='sw-form-capture-email-input']");
    private final SelenideElement passwordInput = $x("//input[@id='sw-form-password-input']");
    private final SelenideElement checkBox = $x("//span[@class='checkmark position-relative sw-checkbox']");
    private final SelenideElement signUpButton = $x("//a[@id='sw-sign-up-submit-btn']");
    private final SelenideElement avatarButton = $x("//div[@class='MuiBox-root css-4tv0ih']");
    private final SelenideElement signOutButton = $x("//span[normalize-space()='Sign Out']");

    private final SelenideElement forgotPasswordLink = $x("//a[normalize-space()='Forgot password']");
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String defaultUserName = "YouCanDeleteMe";
    String defaultPassword = "123456";
    String role = "teacher";

    WebDriver driver;

//    @Given("Open website {string}")
//    public void openWebsite() {
//        String url = "https://jere.softr.app";
//        Selenide.open(url);
//    }
@Given("Open website {string}")
public void openWebsite(String url) {
//    WebDriverManager.chromedriver().setup();
//    driver = new ChromeDriver();
    Selenide.open(url);
}
    @When("Click on signUpButton")
    public void clickOnSignUpButton() {
        signUpHeaderButton.click();
    }
    @And("Select role")
    public void selectRole() {
        selectRoleDropDown.click();
        teacherRole.click();
    }
    @And("Fill Registration fields")
    public void fillRegistrationFields() {
        fillField(fullNameInput, defaultUserName);
        fillField(emailInput, email);
        fillField(passwordInput, defaultPassword);
    }
    @And("Click on checkbox: I agree to the Terms and Privacy Policy")
    public void clickOnCheckbox() {
        checkBox.click();
    }
    @And("Click on signUp button")
    public void clickOnSignUp() {
        signUpButton.click();
    }

    @And ("Sign Out")
    public void signOut() {
    avatarButton.click();
    signOutButton.click();
    }
    @Then("User signed out")
    public void userCanSignOut() throws InterruptedException {
    forgotPasswordLink.isDisplayed();
    }

    public void fillField(SelenideElement field, String text) {
        field.click();
        field.clear();
        field.sendKeys(text);
    }
}

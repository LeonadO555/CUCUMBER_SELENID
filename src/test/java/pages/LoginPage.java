package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends MainPage{
    public final SelenideElement selectRoleDropDown = $x("//div[@class='filter-option-inner-inner']");
    public final SelenideElement teacherRole = $x("//span[normalize-space()='teacher']");
    public final SelenideElement fullNameInput = $x("//input[@id='sw-form-capture-full_name-input']");
    public final SelenideElement emailInput = $x("//input[@id='sw-form-capture-email-input']");
    public final SelenideElement passwordInput = $x("//input[@id='sw-form-password-input']");
    public final SelenideElement checkBox = $x("//span[@class='checkmark position-relative sw-checkbox']");
    public final SelenideElement signUpButton = $x("//a[@id='sw-sign-up-submit-btn']");
    public final SelenideElement avatarButton = $x("//div[@class='MuiBox-root css-4tv0ih']");
    public final SelenideElement signOutButton = $x("//span[normalize-space()='Sign Out']");

    public void fillField(SelenideElement field, String text) {
        field.click();
        field.clear();
        field.sendKeys(text);
    }
}

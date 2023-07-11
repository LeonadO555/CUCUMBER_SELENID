package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class LoginPage {

    public final SelenideElement signInForm = Selenide.$x("//div[@id='signin']");
    public final SelenideElement emailInput = Selenide.$x("//input[@type='email']");
    public final SelenideElement passwordInput = Selenide.$x("//input[@type='password']");
    public final SelenideElement signInButton = Selenide.$x("//a[@id='sw-sign-in-submit-btn']");
    public final SelenideElement signUpButton = Selenide.$x("//a[@id='sw-go-to-sign-up-btn']");



    public void fillInput(SelenideElement field, String text) {
        field.click();
        field.clear();
        field.sendKeys(text);
    }



}

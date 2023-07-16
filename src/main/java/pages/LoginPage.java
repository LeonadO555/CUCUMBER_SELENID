package pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public SelenideElement loginTable = $x("//div[@id='signin']");
    public SelenideElement emailInput = $x("//input[@placeholder='Email']");
    public SelenideElement passwordInput = $x("//input[@placeholder='Password']");
    public SelenideElement signInButton = $x("//a[@id='sw-sign-in-submit-btn']");

}

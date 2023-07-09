package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public final SelenideElement signUpHeaderButton = $x("//span[normalize-space()='Sign up']");
}

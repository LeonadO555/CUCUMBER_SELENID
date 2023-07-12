package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public final SelenideElement signUpHeaderButton = $x("//span[normalize-space()='Sign up']");
    public final SelenideElement signInHeaderButton = $x("//span[normalize-space()='Sign in']");

    public void clickOnSignInButton() {
        signInHeaderButton.click();
    }

    public void checkUserLoggedOut() {
        Assert.assertTrue(signUpHeaderButton.should(Condition.visible).exists());
    }
}

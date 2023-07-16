package pages;

import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$x;


public class HomePage {
    public SelenideElement signInButton = $x("//span[normalize-space()='Sign in']");
    public SelenideElement avatarButton = $x("//span[normalize-space()='Student Directory']");


}

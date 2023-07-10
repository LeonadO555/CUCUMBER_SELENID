package pages;

import org.openqa.selenium.By;

public class SignInPage {
    public By emailInput =By.xpath("//input[@placeholder='Email']");
    public By passwordInput =By.xpath("//input[@placeholder='Password']");
    public By signInButton =By.xpath("//a[@id='sw-sign-in-submit-btn']");
    public By addCourseText =By.xpath("//span[normalize-space()='Add course']");
    public By invalidEmailOrPasswordErrorMessage = By.xpath("//div[@class='error-message login-error d-block']");
}

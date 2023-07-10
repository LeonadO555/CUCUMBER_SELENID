package pages;

import org.openqa.selenium.By;

public class SignUpPage{
    public By emailInput =By.xpath("//input[@placeholder='Email']");
    public By passwordInput =By.xpath("//input[@placeholder='Password']");
    public By fullNameInput =By.xpath("//input[@placeholder='Full Name']");
    public By CheckboxIAgreeTerms=By.xpath("//span[@class='checkmark position-relative sw-checkbox']");
    public By signUpButton =By.xpath("//a[@id='sw-sign-up-submit-btn']");
    public By selectRoleButton =By.xpath("//div[@class='filter-option-inner-inner']");
    public By selectRoleTeacher =By.xpath("//span[normalize-space()='teacher']");
    public By addCourseText =By.xpath("//span[normalize-space()='Add course']");
    public By userExistErrorMessage = By.xpath("//div[@class='error-message signup-error d-flex']");
}

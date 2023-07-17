package steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
import pages.student.StudentDirectoryPage;
import pages.student.StudentProfilePage;

public class TeacherCanFindStudentStep extends BaseStep {

    String userEmail = "roxanne@example.com";
    String studentName = "Malik";
    String password = "123456";
    String role = "student";
    String email = "malik@example.com";

    @Given("Open main page {string}")
    public void openMainPage(String string) {
        Selenide.open(string);
    }

    @When("Click on signInButton")
    public void clickOnSignInButton() {
        MainPage mainPage = new MainPage();
        mainPage.clickOnSignInButton();
    }

    @And("Fill authorization fields")
    public void fillAuthorizationFields() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillInput(loginPage.emailInput, userEmail);
        loginPage.fillInput(loginPage.passwordInput, password);
        loginPage.clickOnSubmitButton();
    }

    @And("Go to student directory")
    public void goToStudentDirectory() {
        HomePage homePage = new HomePage();
        homePage.clickOnStudentDirectoryTab();
    }

    @And("Fill input")
    public void fillInput() {
        StudentDirectoryPage studentDirectoryPage = new StudentDirectoryPage();
        studentDirectoryPage.fillStudentName(studentName);
    }

    @And("Select student")
    public void selectStudent() {
        StudentDirectoryPage studentDirectoryPage = new StudentDirectoryPage();
        studentDirectoryPage.clickOnExactUser(studentName);
    }

    @And("Click on view profile")
    public void clickOnViewProfile() {
        StudentDirectoryPage studentDirectoryPage = new StudentDirectoryPage();
        studentDirectoryPage.clickOnViewProfileButton();
    }

    @Then("Information about student is available")
    public void informationAboutStudentIsAvailable() {
        StudentProfilePage studentProfilePage = new StudentProfilePage();
        studentProfilePage.pageContainsInfoAboutStudent(role, studentName, email);
    }
}

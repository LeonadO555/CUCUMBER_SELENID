package steps;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.courses.CourseInfoPage;
import pages.courses.CoursesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;

public class TeacherCanChangeCourseDescriptionStep {

    String userEmail = "roxanne@example.com";
    String password = "123456";
    String courseName = "Biology";
    Faker faker = new Faker();
    String description = faker.lorem().sentence();

    @Given("Open the main page {string}")
    public void openMainPage(String string) {
        Selenide.open(string);
    }

    @When("Go the to authorisation form")
    public void goTheToAuthorisationForm() {
        MainPage mainPage = new MainPage();
        mainPage.clickOnSignInButton();
    }

    @And("Register as existing teacher")
    public void registerAsExistingTeacher() {
        LoginPage loginPage = new LoginPage();
        loginPage.fillField(loginPage.emailInput, userEmail);
        loginPage.fillField(loginPage.passwordInput, password);
        loginPage.clickOnSubmitButton();
    }

    @And("Go to courses page")
    public void goToCoursesPage() {
        HomePage homePage = new HomePage();
        homePage.goToCoursesPage();
    }

    @And("Select course")
    public void selectCourse() {
        CoursesPage coursesPage = new CoursesPage();
        coursesPage.fillSearchInput(courseName);
        coursesPage.clickOnExactCourse();
    }

    @And("Edit course description")
    public void editCourseDescription() {
        CourseInfoPage courseInfoPage = new CourseInfoPage();
        courseInfoPage.clickOnEditIcon();
        courseInfoPage.fillDescriptionField(description);
        courseInfoPage.clickOnSaveButton();
    }

    @Then("Description changed")
    public void descriptionChanged() {
        CourseInfoPage courseInfoPage = new CourseInfoPage();
        courseInfoPage.pageContainsNewDescription(description);
    }
}

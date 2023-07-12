package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends MainPage {
    public final SelenideElement studentDirectoryTab = $x("//span[normalize-space()='Student Directory']");
    public final SelenideElement coursesTab = $x("//div[@class=\"container MuiBox-root css-0\"]//a[@role='button']//span");
    public final SelenideElement coursesListButton = $x("//div[@class=\"container MuiBox-root css-0\"]//a[@href='/course-list']");

    public void clickOnStudentDirectoryTab() {
        studentDirectoryTab.click();
    }

    public void goToCoursesPage() {
        coursesTab.click();
        coursesListButton.click();
    }
}

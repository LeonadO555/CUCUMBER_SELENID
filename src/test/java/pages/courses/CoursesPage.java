package pages.courses;

import com.codeborne.selenide.SelenideElement;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.$x;

public class CoursesPage extends MainPage {
    public final SelenideElement searchInput = $x("//input[@id=':r0:']");
    public final SelenideElement firstCourse = $x("(//a)[10]");

    public void fillSearchInput(String courseName) {
        searchInput.click();
        searchInput.sendKeys(courseName);
    }

    public void clickOnExactCourse() {
        firstCourse.click();
    }
}

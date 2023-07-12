package pages.student;

import com.codeborne.selenide.SelenideElement;
import pages.MainPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentDirectoryPage extends MainPage {
    public final SelenideElement searchInput = $x("//input[@id=':r0:']");
    public final SelenideElement viewProfileButton = $x("//a[normalize-space()='View profile']");

    public void fillInput(String studentName) {
        searchInput.click();
        searchInput.sendKeys(studentName);
    }

    public void clickOnExactUser(String textForLocator) {
        $(byText(textForLocator)).click();
    }

    public void clickOnViewProfileButton() {
        viewProfileButton.click();
    }

}

package pages.courses;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import pages.MainPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CourseInfoPage extends MainPage {

    public final SelenideElement editIcon = $x("//div[@id='modal-trigger']");
    public final SelenideElement descriptionInput = $(".ProseMirror.toastui-editor-contents");
    public final SelenideElement saveButton = $x("(//button[normalize-space()='Save'])[1]");

    public void clickOnEditIcon() {
        editIcon.click();
    }

    public void fillDescriptionInput(String text) {
        descriptionInput.click();
        descriptionInput.clear();
        descriptionInput.sendKeys(text);
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }

    public void pageContainsNewDescription(String description) {
        Assert.assertTrue($(byText(description)).shouldBe(Condition.visible).exists());
    }
}

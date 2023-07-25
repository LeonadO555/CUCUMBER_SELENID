package pages.student;

import com.codeborne.selenide.Condition;
import org.junit.Assert;
import pages.MainPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StudentProfilePage extends MainPage {
    public void pageContainsInfoAboutStudent(String role, String name, String email) {
        Assert.assertTrue($(byText(role)).shouldBe(Condition.visible).exists()
                && $(byText(name)).shouldBe(Condition.visible).exists()
                && $(byText(email)).shouldBe(Condition.visible).exists());
    }
}

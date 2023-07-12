package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class HomePage {
    public final SelenideElement addCourseButton = Selenide.$x("//a[@href='/add-course']");

}

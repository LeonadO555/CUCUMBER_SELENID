package hooks;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;

public class AfterSteps {
    @io.cucumber.java.After
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }


}

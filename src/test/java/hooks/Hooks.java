package hooks;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;

public class Hooks {
    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}

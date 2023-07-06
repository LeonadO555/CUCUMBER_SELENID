package hooks;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;

public class Hooks {
    // I want to use this method!
//    @Before
//    public void setUp(){
//        System.out.println("---Before method started---");
//        System.setProperty("chromeoptions.args", "--remote-allow-origins=*");
//        open("https://jere237.softr.app/");
//        clearBrowserCookies();
//        clearBrowserLocalStorage();
//        System.out.println("---Before method finished---");
//    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}

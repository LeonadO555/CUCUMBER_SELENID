package hooks;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.*;

public class Hooks {
    @Before
    public void setUp(){
        System.out.println("---Before method started---");
        System.setProperty("chromeoptions.args", "--remote-allow-origins=*");
        open("https://jere237.softr.app");
        clearBrowserCookies();
        clearBrowserLocalStorage();
        System.out.println("---Before method finished---");
       Selenide.open("https://jere237.softr.app/sign-in");

    }

    @After
    public void tearDown(){
        closeWebDriver();
    }
    }

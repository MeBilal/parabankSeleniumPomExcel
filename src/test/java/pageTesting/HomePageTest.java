package pageTesting;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import testSetup.BaseTest;

public class HomePageTest extends BaseTest {

    WebDriver driver;

    @Test
    public void homeRegeButtonTest(){
        HomePage home=startTest();
        home.regestrationClick();
    }
}

package testSetup;

import browser.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

public class BaseTest {

    WebDriver driver;
    HomePage home;

    @BeforeTest
    public void beforeMethode(){
        DriverFactory.setDriver();
        driver=DriverFactory.getDriver();
        driver.navigate().to(DriverFactory.propsConfig().getProperty("url"));
    }

    public HomePage startTest(){
        return PageFactory.initElements(driver,HomePage.class);
    }
}

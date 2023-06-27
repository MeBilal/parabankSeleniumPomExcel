package pages;

import browser.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath="//*[@id=\"loginPanel\"]/p[2]/a") private WebElement regestrationButton;
      WebDriver driver= DriverFactory.getDriver();
    public RegestrationPage regestrationClick(){
        regestrationButton.click();
        return PageFactory.initElements(driver,RegestrationPage.class);
    }
}

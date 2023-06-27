package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

public class RegestrationPage {

    @FindBy(id="customer.firstName") private WebElement firstName;
    @FindBy(id="customer.lastName") private WebElement lastName;
    @FindBy(id="customer.address.city") private WebElement city;
    @FindBy(id="customer.address.state") private WebElement state;
    @FindBy(id="customer.username") private WebElement userName;
    @FindBy(id="customer.address.street") private WebElement address;
    @FindBy(id="customer.address.zipCode") private WebElement zipCode;
    @FindBy(id="customer.phoneNumber") private WebElement phoneNumber;
    @FindBy(id="customer.ssn") private WebElement ssn;
    @FindBy(id="customer.password") private WebElement passWord;
    @FindBy(id="repeatedPassword") private WebElement confirmPass;


    @FindBy(css ="input[value='Register']") private WebElement submit;

    public void register(String firstName, String lastName, String city, String statw,String address,
                         String zipCode, String phoneNumber, String ssn,String userName, String passWord, String passWordConf

    ){

        this.firstName.sendKeys(firstName);

        this.lastName.sendKeys(lastName);
        this.state.sendKeys(statw);
        this.userName.sendKeys(userName);
        this.confirmPass.sendKeys(passWordConf);
        this.city.sendKeys(city);
        this.address.sendKeys(address);
        this.zipCode.sendKeys(zipCode);
        this.phoneNumber.sendKeys(phoneNumber);
        this.ssn.sendKeys(ssn);
        this.passWord.sendKeys(passWord);
        submit.click();

    }
}

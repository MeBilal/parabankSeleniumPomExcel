package pageTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegestrationPage;
import testDataClasses.DataProviderClass;
import testSetup.BaseTest;

public class RegestrationTest extends BaseTest {

    @Test(dataProvider = "dataprovider",dataProviderClass = DataProviderClass.class)
    public void testRegestration(String firstName, String lastName, String city, String statw,String address,
                                 String zipCode, String phoneNumber, String ssn,String userName, String passWord, String passWordConf){
      HomePage home= startTest();
      RegestrationPage regePage=home.regestrationClick();
      regePage.register(firstName, lastName, city, statw,address,
              zipCode, phoneNumber, ssn,userName, passWord, passWordConf);



    }
}

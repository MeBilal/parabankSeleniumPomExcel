package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

    BufferedReader reader;
   public static Properties propsConfig (){
       BufferedReader reader;
       Properties props;
        try {

            reader = new BufferedReader(new FileReader("C:\\Bilal\\paraBankDemo\\configs\\Configurations.properties"));
            props=new Properties();

            try {
                props.load(reader);
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return props;

    }

    private static WebDriver driver;
    private static String nameOfBrowser=propsConfig().getProperty("browserName");

    public static void setDriver(){

        if(nameOfBrowser.equals("FireFox")){
            driver=new FirefoxDriver();
        } else if (nameOfBrowser.equals("Edg")) {
            driver=new EdgeDriver();
        }else {
            driver=new ChromeDriver();
        }


    }

    public static WebDriver getDriver(){
        return driver;
    }
}

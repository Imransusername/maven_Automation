package PageObjectModel.google;

import Day13_05202018.Abstract_Class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class google_homepage extends Abstract_Class {
    ExtentTest logger;
    WebDriver driver;

    public google_homepage(WebDriver driver){
        //super();
        this.driver= Abstract_Class.driver;
        this.logger=Abstract_Class.logger;
        }//publilc google

    public google_homepage googleSearch(String value, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);





    }









}//end of public class

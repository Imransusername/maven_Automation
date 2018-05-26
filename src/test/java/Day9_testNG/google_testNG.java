package Day9_testNG;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class google_testNG {
    WebDriver driver;
    SoftAssert softAssert = null;
    @BeforeMethod
    public void openBrowser(){
        //define the chrome driver using reusable method
         driver = Reusable.Methods.chromeDriver();
    }

    @Test
    public void testScenario(){
        softAssert = new SoftAssert();
        driver.navigate().to("http://google.com");
        //verify im on the right page by using assertion asserequals
        softAssert.assertEquals("Gopqooogle",driver.getTitle());
        //lets verify if the google image is displayed or not using assert true
        //entering name on search field
      Reusable.Methods.sendKeys(driver,"//*[@name='q']", "brooklyn");
      Reusable.Methods.click(driver,"//*[@id='body']");
        Reusable.Methods.click(driver,"//*[@name='btnK']");
    }


    @AfterMethod
            public void closeBrowser() {
            driver.quit();
            softAssert.assertAll();
    }










}

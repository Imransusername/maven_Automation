package Day11_05122018;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

public class ExtentReport_TestNG {
    WebDriver driver;
     ExtentReports reports;
     ExtentTest logger;
    @BeforeSuite
    public void openDriver() {
        driver = Reusable.Methods.chromeDriver();
        reports = new ExtentReports("C:\\Users\\Jannatul Fardaus\\Documents\\Extent reports\\reports.html",true);
    }
        @AfterSuite
        public void closeDriver() {
            //driver.quit();
            reports.flush();
            reports.close();
        }

        @Test
        public void testSenario(){
        logger = reports.startTest("Google search");
        //navigate to google
            logger.log(LogStatus.INFO, "Navigating to google");
            driver.navigate().to("https://www.google.com");

            //wait few seconds for page to load
            logger.log(LogStatus.INFO,"waiting on google to load");

            //assert that title page is google
            logger.log(LogStatus.INFO,"verify that the title of the page is google");
            //Assert.assertEquals("google",driver.getTitle());

            String actualTitle= driver.getTitle();
            if (actualTitle.equalsIgnoreCase("google")){
                logger.log(LogStatus.PASS,"title of page is google");
            }else{
                logger.log(LogStatus.FAIL,"Title is not google");
            }








            //end the test
            reports.endTest(logger);








        }






























}//end of pubulic class

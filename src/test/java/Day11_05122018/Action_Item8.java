package Day11_05122018;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

import java.io.File;
import java.io.IOException;



public class Action_Item8 {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    @BeforeSuite
    public void openDriver() {
        driver = Reusable.Methods.chromeDriver();
        reports = new ExtentReports("C:\\Users\\Jannatul Fardaus\\Documents\\Extent reports\\reports.html", true);
    }

    @AfterSuite
    public void closeDriver() {
        //driver.quit();
        reports.flush();
        reports.close();
    }

    @Test
    public void testScenario() throws InterruptedException, IOException {
        //log test name using logger
        logger = reports.startTest("Action Item 7, UPS");

        //navigate to google.com
        logger.log(LogStatus.INFO, "navigating to UPS.com");
        driver.navigate().to("https://www.ups.com/us");

        //Wait few seconds
        logger.log(LogStatus.INFO, "Waiting for page to load");
        Thread.sleep(2500);

        //Assert that title page is google
        logger.log(LogStatus.INFO, "Verify the title of the page is 'Shipping | UPS'");
        //Assert.assertEquals("Google",driver.getTitle());
        //to use assetions with Extend report
        String expectedTitle, actualTitle;
        expectedTitle = "Shipping | UPS";
        actualTitle = driver.getTitle();


        if (actualTitle.equalsIgnoreCase(expectedTitle)) {
            logger.log(LogStatus.PASS, "Title of page is UPS");
        } else {
            logger.log(LogStatus.FAIL, "Title of page is not UPS \"" + expectedTitle + "\"it is: " + actualTitle);
        }
        //define the path of the image
        String imagePath = "C:\\Users\\Jannatul Fardaus\\Documents\\Extent reports\\upsscreenshot.png";

        //line below allows you to take the screenshot (don't need to memorize the command)
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //Now you can do whatever you need to do with this, for example copy somewhere

        String image = logger.addScreenCapture(imagePath);

        logger.log(LogStatus.FAIL, "Verify UPS title", image);

        driver.findElement(By.xpath("//*[@id='ups-quickStartQuote']")).click();

        WebElement shipment = driver.findElement(By.xpath("//*[@name='shipmentType']"));
        Select dropdown = new Select(shipment);
        dropdown.selectByVisibleText("Letter");

        WebElement shipFrom = driver.findElement(By.xpath("//*[@name='origCountry']"));
        Select dropDown = new Select(shipFrom);
        dropdown.selectByVisibleText("United States");

        WebElement shipTO = driver.findElement(By.xpath("//*[@name='destCountry']"));
        Select dropDowN = new Select(shipTO);
        dropdown.selectByVisibleText("United States");

        driver.findElement(By.xpath("//*[@name='weight']")).sendKeys("2");
        driver.findElement(By.xpath("//*[@name='origPostalCode']")).sendKeys("11218");
        driver.findElement(By.xpath("//*[@name='destPostalCode']")).sendKeys("90210");

        Boolean elementState = driver.findElement(By.xpath("//*[@type='checkbox']")).isSelected();

        if (elementState = true) {
            logger.log(LogStatus.FAIL, "Check box is selected" + elementState);
            String imagepath = "C:\\Users\\Jannatul Fardaus\\Documents\\Extent reports\\upss checkbox.png";
            File soureFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String imagE = logger.addScreenCapture(imagePath);
            logger.log(LogStatus.FAIL, "ups checkbox", image);


        } else {
            logger.log(LogStatus.PASS, "Checkbox is not selected");
        }

        driver.findElement(By.xpath("//*[@nme='--qs']")).click();
        Thread.sleep(2000);
    }//end of test 1

    @Test(dependsOnMethods = "testSenario")
    public void testScenario2() throws InterruptedException {
        logger.log(LogStatus.INFO, "verify calucaltions page");
        String actualTitle = driver.getTitle();

        if (actualTitle.equalsIgnoreCase("Calculate Time and Cost")) {
            logger.log(LogStatus.PASS, "Title of page is calculate time and cost");
        } else {
            logger.log(LogStatus.FAIL, "Title of page is not title and cost" + actualTitle);
            String imagePath = "C:\\Users\\Jannatul Fardaus\\Documents\\Extent reports\\upss checkbox.png";
            File sourcefile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String image = logger.addScreenCapture(imagePath);
            logger.log(LogStatus.FAIL, "calculation", image);

            driver.findElements(By.xpath("//*[@value = 'ship now")).get(0).click();
            Thread.sleep(3000);

            logger.log(LogStatus.INFO, "verify Shipping UPS page");
            actualTitle = driver.getTitle();

            if (actualTitle.equalsIgnoreCase("Shipping ups")) {
                logger.log(LogStatus.PASS, "Title of page is calculate time and cost");
            } else {
                logger.log(LogStatus.FAIL, "Title of page is not Shipping ups" + actualTitle);
                String ImagePath = "C:\\Users\\Jannatul Fardaus\\Documents\\Extent reports\\upss checkbox.png";
                File sourcefilE = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String Image = logger.addScreenCapture(ImagePath);
                logger.log(LogStatus.FAIL, "Shipping", image);
            }


        }





    }//end of test 2



}//end of public class

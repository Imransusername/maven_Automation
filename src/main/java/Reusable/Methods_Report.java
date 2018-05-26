package Reusable;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Methods_Report {
  public static int timeout = 50;

    //chromedriver method needs to be a return class to be used on your execution class
    public static WebDriver chromeDriver(){
        // connecting to chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jannatul Fardaus\\IdeaProjects\\MavenProject\\src\\main\\resources\\chromedriver.exe");
        //defining chrome option
        ChromeOptions options = new ChromeOptions();
        //adding an argument to the option to maximize the browser
        options.addArguments("start-maximized");
        //defining the chrome driver and passing the option argument to the driver
        WebDriver driver = new ChromeDriver(options);
        //we are returning the driver variable because it's storing the chromdriver(option)
        return driver;
    }

    public static void click(WebDriver driver, String locator, ExtentTest logger, String elementName) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            logger.log(LogStatus.INFO,"Clicking on an element " + elementName);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).click();
        }catch (Exception e){
            logger.log(LogStatus.FAIL,"unable to click on element " + elementName);
            getScreenshot(driver,logger);
        }

    }//end of click method

    public static void sendKeys(WebDriver driver, String locator, String userV, ExtentTest logger, String elementName) throws IOException {
        WebDriverWait wait = new WebDriverWait( driver,timeout);
        try{
            logger.log(LogStatus.INFO,"Entering a value " +userV+ "on element" + elementName);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).sendKeys(userV);
        }catch(Exception e){
            logger.log(LogStatus.FAIL,"Unable to enter a value " + elementName);
            getScreenshot(driver, logger);
        }
    }//end of sendKeys method

    public static String getText(WebDriver driver, String locator,ExtentTest logger, String elementName) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,timeout);

        String text = null;
        try{
            logger.log(LogStatus.INFO,"Capturing text from element" + elementName);
            text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).getText();

        }catch(Exception e){
            System.out.println("Unable to get text from locator."+e);
            logger.log(LogStatus.FAIL,"unable to capture text from element " + elementName);
            getScreenshot(driver, logger);
        }
        return text;
    }//end of getText method

    public static void hover(WebDriver driver, String locator,ExtentTest logger, String elementName) throws IOException {
        Actions mouseAction = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,timeout);

        try{
            logger.log(LogStatus.INFO,"Hovering over an element" + elementName);
            //now wait until element "Quick Tool" appears on the page
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

            //now I can store the above element in a web element locator to hover using mouse action.
            WebElement itemToHoverOver = driver.findElement(By.xpath(locator));

            //line below ill over over to that element using mouse movement
            mouseAction.moveToElement(itemToHoverOver).build().perform();

        }catch(Exception e){
            logger.log(LogStatus.FAIL,"unable to hover over element element " + elementName);
            System.out.println("Unable to find hover."+e);
            getScreenshot(driver,logger);
        }
    }//end of hover method

    public static void scrollintoElement (WebDriver driver, String locator){
        WebDriverWait wait=  new WebDriverWait(driver, timeout);
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        try{
            WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            jse.executeScript("arguments[0].scollIntoView(ture);", element);
        }catch (Exception e){
            System.out.println("Unable to scoll into element " + e);
        }
    }//end of scroll into element

    public static void getScreenshot(WebDriver driver, ExtentTest logger) throws IOException {
        String path = "C:\\Users\\Jannatul Fardaus\\Pictures\\ExtentReports\\";
        //String path = "src\\main\\java\\externalFiles\\ScreenShots\\";
        String fileName = "image"+ UUID.randomUUID() + ".png";
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Now you can do whatever you need to do with, for example copy somewhere
        FileUtils.copyFile(sourceFile, new File(path + fileName));
        //String imgPath = directory + fileName;
        String image = logger.addScreenCapture(fileName);
        logger.log(LogStatus.FAIL, "", image);
    }






}//end of public class

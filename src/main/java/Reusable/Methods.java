package Reusable;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Methods {
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

    public static void click(WebDriver driver, String locator){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).click();
        }catch (Exception e){
            System.out.println("Unable to enter th user vaules on sendkeys " + e);
        }

    }//end of click methods

    public static void sendKeys(WebDriver driver, String locator, String userV){
        WebDriverWait wait = new WebDriverWait( driver,timeout);
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).sendKeys(userV);
        }catch(Exception e){
            System.out.println("Unable to enter the user values on sendKeys"+e);
        }
    }//end of sendKeys method

    public static String getText(WebDriver driver, String locator){
        WebDriverWait wait = new WebDriverWait(driver,timeout);

        String text = null;
        try{
            text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).getText();

        }catch(Exception e){
            System.out.println("Unable to get text from locator."+e);
        }
        return text;
    }//end of getText method

    public static void hover(WebDriver driver, String locator){
        Actions mouseAction = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,timeout);

        try{

            //now wait until element "Quick Tool" appears on the page
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

            //now I can store the above element in a web element locator to hover using mouse action.
            WebElement itemToHoverOver = driver.findElement(By.xpath(locator));

            //line below ill over over to that element using mouse movement
            mouseAction.moveToElement(itemToHoverOver).build().perform();

        }catch(Exception e){
            System.out.println("Unable to find hover."+e);
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
    }



}//end of public class

package Day13_05202018;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.util.UUID;

public class Abstract_Class {
    //declaring all your variables
    public static  WebDriver driver;
    public static SoftAssert softAssert;
    public static ExtentReports reports;
    public static ExtentTest logger;

    @Parameters("browser")
    @BeforeSuite
    public static void defineBrowser(String browser){
        if (browser.equalsIgnoreCase("firefox")) {
            reports= new ExtentReports("C:\\Users\\Jannatul Fardaus\\Pictures\\ExtentReports\\Firefox Reports " + UUID.randomUUID()+ ".html",true);
            //defining the path for geckodriver
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Jannatul Fardaus\\IdeaProjects\\MavenProject\\src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
            //maximize firefox
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("chrome")) {
            reports= new ExtentReports("C:\\Users\\Jannatul Fardaus\\Pictures\\ExtentReports\\Chrome Reports " + UUID.randomUUID()+ ".html",true);
            //defining chrome driver
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jannatul Fardaus\\IdeaProjects\\MavenProject\\src\\main\\resources\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        }
    }//end of public void

    //before method is only defined to capture you test method to imoprt to your HTML report
    @BeforeMethod
    public static void methodName(Method method){
        logger = reports.startTest(method.getName());
    }

    //after method to end the test you are running on your xml suite
    @AfterMethod
    public static void endTest(){
        reports.endTest(logger);

    }

    //close and flush the reports and either quit the driver or open your html report
    @AfterSuite
    public static void endSuite(){
        //flush the report
        reports.flush();
        //close the report
        reports.close();

        //quit the path
        driver.quit();
    }















}//end of public class

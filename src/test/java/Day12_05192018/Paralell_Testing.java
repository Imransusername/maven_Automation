package Day12_05192018;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.sql.SQLOutput;

public class Paralell_Testing {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    @Parameters("browser")
    @BeforeMethod
    public void openBrowser(String browser) throws InterruptedException {
        reports= new ExtentReports("C:\\Users\\Jannatul Fardaus\\Documents\\Extent reports\\reports.html");
        if (browser.equalsIgnoreCase("firefox")) {
            //defining the path for geckodriver
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Jannatul Fardaus\\IdeaProjects\\MavenProject\\src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
            //maximize firefox
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("chrome")) {
            //defining chrome driver
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jannatul Fardaus\\IdeaProjects\\MavenProject\\src\\main\\resources\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);

        }

    }//end of public void


        @Test
        public void testSenario() throws InterruptedException {
            driver.navigate().to("https://www.facebook.com");
            Thread.sleep(3000);
        }

        @AfterMethod
    public void closeBrowser(){
        driver.quit();
        }


}//end of public class

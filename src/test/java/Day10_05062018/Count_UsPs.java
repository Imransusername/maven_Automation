package Day10_05062018;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Count_UsPs {
    WebDriver driver;


    @BeforeMethod
    public void openBrowser(){
         driver = Reusable.Methods.chromeDriver();
    }





    @Test
    public void testScenario() throws InterruptedException {

        driver.navigate().to("https://www.usps.com/");
        Thread.sleep(3000);
        List<WebElement> tabcount = driver.findElements(By.xpath("//*[@class='menuitem']"));
        System.out.println("The tab count is " + tabcount.size());

        for (int i = 0; i < tabcount.size(); i++) {

            String getName = driver.findElements(By.xpath("//*[@class='menuitem']")).get(i).getText();
            System.out.println("My tab is " + getName);
        }//end of loop


    } //end of loop

        @AfterMethod
        public void closeBrowser(){
            driver.quit();


        }

}//end of public class

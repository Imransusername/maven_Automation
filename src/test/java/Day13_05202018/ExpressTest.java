package Day13_05202018;

import Reusable.Methods_Report;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExpressTest extends Abstract_Class {
    @Test
    public void expressCheckout() throws IOException, InterruptedException {
        driver.navigate().to("https://www.express.com");
        //hover over Women using reusable mouse action method
        Methods_Report.hover(driver, "//*[@href='/womens-clothing']", logger, "Womans tab");
        //hover over accessories
        Methods_Report.hover(driver, "//*[@class='subnav-target' and contains(@href,'/womens-clothing/accessories')]", logger, "Accesories");
        //clicking on Jewelry
        Methods_Report.click(driver, "//*[contains(@href,'/womens-clothing/accessories/jewelry/')]", logger, "Jewlery");
        //click on earrings
        Methods_Report.click(driver, "//*[text()='Earrings']", logger, "Earrings");
        //assert that i'm on the right page
        String pageName = driver.getTitle();
        if (pageName.equalsIgnoreCase("Earrings for Women - Earrigs")) {
            logger.log(LogStatus.INFO, "Page name is correct");
        } else {
            logger.log(LogStatus.FAIL, "Page name is not correct");
            Methods_Report.getScreenshot(driver,logger);
        }
        //hover over first image on the selection
        Methods_Report.hover(driver,"//*[@class='active loaded']",logger,"First image");
        //click on Express View
        Methods_Report.click(driver,"//*[@class='express-view']",logger,"Express View");
        //click on the second color
        Thread.sleep(2000);
        driver.findElements(By.xpath("//*[@class='color-swatch']")).get(1).click();
        //click on Add to bag
        Methods_Report.click(driver,"//*[text()='Add to Bag']",logger,"addinng to bag");
        //hover over Bag icon
        Methods_Report.hover(driver,"//*[@class='bag-icon']",logger,"bag icon");
        //click on Checkout
        Methods_Report.click(driver,"//*[text()='CHECKOUT']",logger,"Checkout button");





    }//end of void class
    @Test(dependsOnMethods = "expressCheckout")
    public void addQuantity() throws IOException {
        //click on the quantity drop down
        Methods_Report.click(driver, "//*[@id='qdd-0-quantity']", logger, "Quantity Dropdown");
        //click on the quantity value
        Methods_Report.click(driver, "//*[@value='2']", logger, "Quantity Value");

    }








//hooplah




}//end of public class

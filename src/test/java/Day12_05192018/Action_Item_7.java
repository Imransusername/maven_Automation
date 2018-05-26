package Day12_05192018;

import Reusable.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Action_Item_7 {
    WebDriver driver;
    SoftAssert softAssert;

    @BeforeMethod
    public void openbrowser(){
        driver= Methods.chromeDriver();

    }

    @Test(priority=1)
    public void prioritytest1() throws InterruptedException {
        softAssert = new SoftAssert();
        driver.navigate().to("https://www.express.com/");
        Thread.sleep(2000);
        Methods.click(driver, "//*[contains(@aria-label,'Women')]");
        Thread.sleep(4000);
        Methods.click(driver,"//*[contains(@aria-label,'Accessories.')]");
        Methods.click(driver,"//*[contains(@aria-label,'Accessories.')]");
        Methods.click(driver,"//*[contains(@aria-label,'Jewelry')]");
        Methods.click(driver, "//*[contains(@href, 'earings']");
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@class='header top-padding']")).isDisplayed(),"Earrings for Women - Earrings");
        Methods.hover(driver, "//*[@alt='large metal hoop earrings']");
        Methods.click(driver, "//*[@class='express-view']");
        Methods.click(driver, "//*[@class='color-swatch']");
        Methods.click(driver, "//*[@role='button']");
        Methods.hover(driver, "//*[@class='bag-icon']");
        Methods.click(driver, "//*[@class='exp-medium']");

        softAssert.assertEquals (driver.findElement(By.xpath("//*[contains(@class, 'grid--direction-column']")).isDisplayed(),"My Shopping Bag | Express");
       // String qty = driver.findElements(By.xpath("//*[@id='qdd-0-quantity']").click());
        //Select dropDown = new Select(qty);
        //dropDown.selectByVisibleText("2");
        Methods.click(driver, "//*[@aria-label='Continue to Checkout']");
        Methods.click(driver, "//*[@class='btn _2u-IO _1n1el _1MBdF']");
        Methods.sendKeys(driver, "//*[@name='firstname']", "Imran");
        Methods.sendKeys(driver, "//*[@name='lastname']", "Shishir");
        Methods.sendKeys(driver, "//*[@name='email']", "Shishir.Imran95@gmail.com");
        Methods.sendKeys(driver, "//*[@name='confirmEmail']", "Shishir.Imran95@gmail.com");
        Methods.sendKeys(driver, "//*[@name='phone']", "3472387956");


        Methods.sendKeys(driver, "//*[@name='shipping.firstName']", "Imran");
        Methods.sendKeys(driver, "//*[@name='shipping.lastName']", "Shishir");
        Methods.sendKeys(driver, "//*[@name='shipping.line1']", "221 Avenue F");
        Methods.sendKeys(driver, "//*[@name='shipping.postalCode']", "11218");
        Methods.sendKeys(driver, "//*[@name='shipping.city']", "Brooklyn");
        WebElement country = driver.findElement(By.xpath("//*[@name='shipping.countryCode']"));
        Select DropDown = new Select(country);
        DropDown.selectByVisibleText("United States");
        WebElement state = driver.findElement(By.xpath("//*[@name='shipping.state']"));
        Select dRopDown = new Select(country);
        dRopDown.selectByVisibleText("New York");
        boolean shipping = driver.findElement(By.xpath("//*[@type='checkbox']")).isSelected();
        Methods.click(driver, "//*[@type='submit']");
        String message = Methods.getText(driver,"//*[@class='_1oFkX']");
        System.out.println("Info " + message);



















    }















}//end of public class

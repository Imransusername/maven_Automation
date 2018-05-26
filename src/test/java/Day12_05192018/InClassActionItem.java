package Day12_05192018;

import Reusable.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class InClassActionItem {
    WebDriver driver;
    SoftAssert softAssert;

    @BeforeMethod
    //The driver to open up chrome
    public void OpenBrowser(){
        driver =Methods.chromeDriver();

    }

    @Test
    public void testSenario() throws InterruptedException {
        softAssert = new SoftAssert();
                driver.navigate().to("https://www.yahoo.com/");
        softAssert.assertEquals("Yahoo", driver.getTitle());
        Thread.sleep(3000);
        List<WebElement> tabcount = driver.findElements(By.xpath("//*[@class='D(ib) Mstart(21px) Mend(13px)']"));
        System.out.println("The tab count is " + tabcount.size());

        for (int i = 0; i < tabcount.size(); i++) {

            String getName = driver.findElements(By.xpath("//*[@class='D(ib) Mstart(21px) Mend(13px)']")).get(i).getText();
            System.out.println("My tab is " + getName);
        }//end of loop

        Methods.sendKeys(driver,"//*[contains(@id,'uh-search-box')]","Nutrition");
        Methods.click(driver, "//*[contains(@id,'uh-search-button')]");

        JavascriptExecutor jse= (JavascriptExecutor)driver;
        Thread.sleep(2000);
        jse.executeScript("scroll(0,10000)");
        Thread.sleep(2000);
        jse.executeScript("scroll(0,-10000)");

        Methods.click(driver, "//*[contains(@id,'yucs-login_signIn')]");

        boolean elementState= driver.findElement(By.xpath("//*[@type='checkbox']")).isSelected();
        System.out.println("Is Element selected " + elementState);

        Methods.sendKeys(driver,"//*[@id='login-username']","asdasdasdasd");
        Methods.click(driver, "//*[@id='login-signin']");

        String errMsg = "Sorry, we don't recognize this email.";
        String msgErr = Methods.getText(driver, "//*[@id='username-error']");
        softAssert.assertEquals(errMsg,msgErr);




    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
        softAssert.assertAll();
    }




















}//end of class

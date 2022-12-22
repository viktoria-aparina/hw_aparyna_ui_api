package org.pm.ui.google.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MoonTest {

   private WebDriver driver;
   // WebDriverWait wait;

    //WebElement buttonRejectAll = driver.findElement(By.xpath("//div[text()='Reject all']"));
    WebElement input = driver.findElement(By.name("q"));

    String text = "Cat";

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        /*wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));*/

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void noo() {
        driver.get("https://google.com/");
        //log.info("Google Chrome was opened successfully");
       /* if (buttonRejectAll.isDisplayed()) {
            buttonRejectAll.click();
        } else {
*/
        WebElement input = driver.findElement(By.name("q"));
            input.sendKeys(text);
            input.sendKeys(Keys.ENTER);


}
}

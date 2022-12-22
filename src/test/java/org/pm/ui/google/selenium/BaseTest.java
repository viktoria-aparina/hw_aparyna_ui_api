package org.pm.ui.google.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    GoogleSearchFormPage googleSearchFormPage;
    SearchResultPage searchResultPage;
    CatPage catPage;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        googleSearchFormPage = new GoogleSearchFormPage(driver);
        searchResultPage = new SearchResultPage(driver);
        catPage = new CatPage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

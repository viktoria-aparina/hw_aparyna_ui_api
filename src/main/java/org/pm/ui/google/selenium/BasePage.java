package org.pm.ui.google.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pm.utils.DefaultConfig;

import java.time.Duration;

public abstract class BasePage {

    //String googleBaseUrl;
    WebDriver driver;
    WebDriverWait wait;
    Logger log;

    public BasePage(WebDriver driver) {
        this.driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //googleBaseUrl = DefaultConfig.getInstance().getUrl("google.baseUrl");
        log = Logger.getLogger(BasePage.class);
    }

    public abstract boolean isPageOpened();
}

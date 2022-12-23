package org.pm.ui.google.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pm.utils.DefaultConfig;
import java.time.Duration;

public abstract class BasePage {

  WebDriver driver;
  WebDriverWait wait;
  Logger log;
  String googleBaseUrl = DefaultConfig.getInstance().getUrl("google.baseUrl");

  public BasePage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    log = Logger.getLogger(BasePage.class);
  }
}

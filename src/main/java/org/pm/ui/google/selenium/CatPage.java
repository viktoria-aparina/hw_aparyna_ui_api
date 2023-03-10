package org.pm.ui.google.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CatPage extends BasePage {

  public CatPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public boolean isPageOpened() {
    try {
      wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("result-start")));
      log.info("The page CatPage was opened successfully");
      return true;
    } catch (TimeoutException exception) {
      log.error("The page CatPage was not opened, because of error {}", exception.getCause());
      return false;
    }
  }
}

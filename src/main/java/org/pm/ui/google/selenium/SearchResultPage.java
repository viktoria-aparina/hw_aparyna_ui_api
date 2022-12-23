package org.pm.ui.google.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends BasePage {

  public SearchResultPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public boolean isPageOpened() {
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
      log.info("The page SearchResultPage was opened successfully");
      return true;
    } catch (TimeoutException exception) {
      log.error("The page SearchResultPage was not opened, because of error {}", exception.getCause());
      return false;
    }
  }

  public SearchResultPage chooseAndClickOnPageNumber(int number) {
    driver.findElement(By.xpath(String.format("//a[text()='%s']", number))).click();
    log.info("Click on entered number was successful");
    return this;
  }

  public CatPage selectById(Integer orderId) {
    driver.findElements(By.tagName("h3")).get(orderId).click();
    log.info("The page CatPage was opened successfully");
    return new CatPage(driver);
  }
}

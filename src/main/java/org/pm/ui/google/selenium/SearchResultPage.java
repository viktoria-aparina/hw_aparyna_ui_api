package org.pm.ui.google.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BasePage {

  public SearchResultPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public SearchResultPage chooseAndClickOnPageNumber(int number) {
    driver.findElement(By.xpath(String.format("//a[text()='%s']", number))).click();
    log.info("Click on entered number was successful");
    return this;
  }

  public CatPage selectById(Integer orderId) {
    driver.findElements(By.tagName("h3")).get(orderId).click();
    log.info("Click on selected link was successful");
    return new CatPage(driver);
  }
}

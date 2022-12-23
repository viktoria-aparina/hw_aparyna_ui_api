package org.pm.ui.google.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchFormPage extends BasePage {

  public GoogleSearchFormPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public GoogleSearchFormPage open() {
    driver.get(googleBaseUrl);
    log.info("Google Chrome was opened successfully");
    if (!driver.findElements(By.xpath("//div[text()='Reject all']")).isEmpty()) {
      driver.findElement(By.xpath("//div[text()='Reject all']")).click();
    }
    return this;
  }

  public SearchResultPage doSearch(String text) {
    WebElement input = driver.findElement(By.name("q"));
    input.sendKeys(text);
    log.info("The text was entered in search input successfully");
    input.sendKeys(Keys.ENTER);
    return new SearchResultPage(driver);
  }
}

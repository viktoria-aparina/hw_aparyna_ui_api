package org.pm.ui.google.selenide;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class GoogleSearchFormPageSelenide {

  private static final Logger log = Logger.getLogger(GoogleSearchFormPageSelenide.class);
  static SelenideElement buttonRejectAll = $(By.xpath("//div[text()='Reject all']"));

  public static GoogleSearchFormPageSelenide open() {
    Selenide.open(baseUrl);
    getWebDriver().manage().window().maximize();
    if (buttonRejectAll.isDisplayed()) {
      buttonRejectAll.click();
    } else {
      $(By.name("q")).shouldBe(enabled);
    }
    log.info("Google Chrome was opened successfully");
    return new GoogleSearchFormPageSelenide();
  }

  public SearchResultPageSelenide doSearch(String text) {
    $(By.name("q")).setValue(text).pressEnter();
    log.info("The text was entered in search input successfully");
    $(By.id("result-stats")).shouldBe(visible);
    log.info("The page SearchResultPage was opened successfully");
    return new SearchResultPageSelenide();
  }
}

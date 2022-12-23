package org.pm.ui.google.selenide;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;

import org.apache.log4j.Logger;

public class CatPageSelenide {

  private static final Logger log = Logger.getLogger(CatPageSelenide.class);

  public static boolean isOpened() {
    webdriver().shouldNotHave(urlStartingWith(baseUrl));
    log.info("The CatPage was opened successfully");
    return true;
  }
}

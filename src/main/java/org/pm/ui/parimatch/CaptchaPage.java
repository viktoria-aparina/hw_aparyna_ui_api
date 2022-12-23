package org.pm.ui.parimatch;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CaptchaPage {

  private static final Logger log = Logger.getLogger(CaptchaPage.class);

  public static boolean isCaptchaFound() {
    boolean captchaFound = $(By.id("captcha__element")).isDisplayed();
    log.info(captchaFound);
    if (captchaFound) {
      log.info("On the page captcha was detected!!!");
    }
    return captchaFound;
  }
}

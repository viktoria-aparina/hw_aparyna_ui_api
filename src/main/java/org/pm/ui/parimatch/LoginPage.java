package org.pm.ui.parimatch;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {

  private static final Logger log = Logger.getLogger(LoginPage.class);

  public LoginPage chooseLoginType() {
    $(By.xpath("//form[@data-id='login-form']/div/div[@data-id='list']")).shouldBe(visible).click();
    $(By.xpath("//form[@data-id='login-form']/div/div//*[@value='id']")).shouldBe(visible).click();
    log.info("Type login was changed successfully");
    return this;
  }

  public Object loginWithTestCred() {
    $(By.id("id")).sendKeys("139833164");
    log.info("ID was entered");
    $(By.id("password")).sendKeys("B@ttleArena");
    log.info("Password was entered");
    $(By.xpath("//button[@data-id='login-button']")).shouldBe(enabled).click();

    if (isCaptchaFound()) {
      return new CaptchaPage();
    }
    return new HomePage();
  }

  public static boolean isOpened() {
    $(By.xpath("//button[@data-id='login-button']")).shouldBe(visible);
    log.info("The LoginPage was opened successfully");
    return true;
  }

  public static boolean isCaptchaFound() {
    boolean captchaFound = $(By.tagName("iframe")).exists();
    log.info(captchaFound);
    if (captchaFound) {
      log.info("On the page captcha was detected!!!");
    }
    return captchaFound;
  }
}

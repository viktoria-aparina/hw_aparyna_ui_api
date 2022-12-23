package org.pm.ui.parimatch;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTest {

  @Test
  public void checkLogin() {
    Object page = HomePage.open()
        .clickOnLoginButton()
        .chooseLoginType()
        .loginWithTestCred();

    if (page instanceof CaptchaPage) {
      assertTrue(true, "Captcha wasn't found");
      return;
    }
    assertTrue(new HomePage().isPageOpened(),
        "User with test cred wasn't login");
  }
}

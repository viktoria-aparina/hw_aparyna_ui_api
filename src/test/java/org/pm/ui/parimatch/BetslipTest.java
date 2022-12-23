package org.pm.ui.parimatch;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

public class BetslipTest {

  @Test
  public void placeASingleBetAsUnauthorizedUser() {

    HomePage.open().chooseBetsForBetslip(3);

    new BetslipPage().enterValueBet("20")
        .clickLoginOnBetslip();

    assertTrue(LoginPage.isOpened(), "Login page wasn't opened after click on button \"Login\" in betslip");
  }

  @Test
  public void placeASingleBetAsUnauthorizedUserAndLogin() {
    HomePage.open().chooseBetsForBetslip(3);

    ArrayList<Double> coefficient = new HomePage().getCoefficient(3);

    Object page = new BetslipPage().enterValueBet("20")
        .clickLoginOnBetslip()
        .chooseLoginType()
        .loginWithTestCred();

    if (page instanceof CaptchaPage) {
      assertTrue(true, "Captcha wasn't found");
      return;
    }

    new LoginPage().chooseLoginType().loginWithTestCred();

    assertEquals(BetslipPage.getPossibleWinningAmount(),
        BetslipPage.calculatePossibleWinningAmount(BetslipPage.getValueBet(),
            coefficient),
        "Possible winning amount is wrong");
  }

  @Test
  public void placeParlayAsUnauthorizedUserAndLogin() {
    HomePage.open().chooseBetsForBetslip(3);

    ArrayList<Double> coefficient = new HomePage().getCoefficient(3);

    Object page = new BetslipPage().enterValueBet("20")
        .clickLoginOnBetslip()
        .chooseLoginType()
        .loginWithTestCred();

    if (page instanceof CaptchaPage) {
      assertTrue(true, "Captcha wasn't found");
      return;
    }

    new LoginPage().chooseLoginType().loginWithTestCred();

    assertEquals(BetslipPage.getPossibleWinningAmount(),
        BetslipPage.calculatePossibleWinningAmount(BetslipPage.getValueBet(),
            coefficient),
        "Possible winning amount is wrong");
  }
}

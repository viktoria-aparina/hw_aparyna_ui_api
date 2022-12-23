package org.pm.ui.parimatch;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class BetslipPage {

  static SelenideElement valueBetLocator = $(By.xpath("//input[@data-id='betslip-stake-input']"));

  public BetslipPage enterValueBet(CharSequence valueBet) {
    valueBetLocator.clear();
    valueBetLocator.sendKeys(valueBet);
    return this;
  }

  public static double getValueBet() {
    return Double.parseDouble(valueBetLocator.getValue());
  }

  public static double getPossibleWinningAmount() { //calc by site
    return Double.parseDouble($(By.xpath("//span[@data-id='betslip-place-bet-button-amount']")).getText());
  }

  public static double calculatePossibleWinningAmount(double valueBet, double... coefficients) { //calc by me
    double result = 0;
    for (int i = 0; i < coefficients.length; i++) {
      result = valueBet * coefficients[i];
    }
    return result;
  }

  public LoginPage clickLoginOnBetslip() {
    $(By.xpath("//button[@data-id='betslip-place-bet-button']")).shouldBe(enabled).click();
    return new LoginPage();
  }
}

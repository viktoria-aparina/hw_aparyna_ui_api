package org.pm.ui.parimatch;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import java.util.ArrayList;

public class HomePage {

  private static final Logger log = Logger.getLogger(HomePage.class);
  ElementsCollection coefficients = $$(By.xpath("//div[@data-id='event-card-container-event']//div[@data-id='animated-odds-value']/span"));

  public static HomePage open() {
    Selenide.open(baseUrl);
    getWebDriver().manage().window().maximize();
    log.info("Chrome Driver was opened successfully");
    return new HomePage();
  }

  public boolean isPageOpened() {
    try {
      $(By.xpath("//div[@data-id='user-box-balance']")).shouldBe(visible);
      return true;
    } catch (TimeoutException exception) {
      log.error("The HomePage wasn't open because of error {}", exception.getCause());
      return false;
    }
  }

  public LoginPage clickOnLoginButton() {
    $(By.xpath("//button[@data-id='header-login']")).click();
    log.info("Click on button \"Увийти\" was successful");
    return new LoginPage();
  }

  public void chooseBetsForBetslip(int... numberOfCoefficient) {
    for (int number : numberOfCoefficient) {
      coefficients.get(number).shouldBe(visible).click();
      log.info("Click on coefficient was successful");
    }
  }

  public ArrayList<Double> getCoefficient(int... numberOfCoefficient) {
    ArrayList<Double> result = new ArrayList<>();
    for (int number : numberOfCoefficient) {
      result.add(Double.parseDouble(coefficients.get(number).getText()));
    }
    return result;
  }
}

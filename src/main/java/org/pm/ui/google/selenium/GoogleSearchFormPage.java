package org.pm.ui.google.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;

public class GoogleSearchFormPage extends BasePage {

    WebElement buttonRejectAll = driver.findElement(By.xpath("//div[text()='Reject all']"));
    WebElement input = driver.findElement(By.name("q"));

    public GoogleSearchFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOf(input));
            log.info("The page GoogleSearchFormPage was opened successfully");
            return true;
        } catch (TimeoutException exception) {
            log.error("The page GoogleSearchFormPage was not opened, because of error {}", exception.getCause());
            return false;
        }
    }

    public GoogleSearchFormPage open() {
        driver.get("https://google.com");
        log.info("Google Chrome was opened successfully");
        if (buttonRejectAll.isDisplayed()) {
            buttonRejectAll.click();
        } else {
            return this;
        }
        return this;
    }

    public SearchResultPage doSearch(String text) {
        input.sendKeys(text);
        log.info("The text was entered in search input successfully");
        input.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }
}

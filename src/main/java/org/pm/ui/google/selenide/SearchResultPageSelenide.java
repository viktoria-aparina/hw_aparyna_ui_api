package org.pm.ui.google.selenide;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.pm.utils.DefaultConfig;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;
import static org.openqa.selenium.By.xpath;

public class SearchResultPageSelenide {

    private static final Logger log = Logger.getLogger(GoogleSearchFormPageSelenide.class);
    private static DefaultConfig config = DefaultConfig.getInstance();

    public SearchResultPageSelenide chooseAndClickOnPageNumber(int number) {
        $(xpath(String.format("//a[text()='%s']", number))).click();
        log.info("Click on entered number was successful");
        return this;
    }

    public CatPageSelenide selectById(Integer orderId) {
        $$(By.tagName("h3")).get(orderId).click();
        webdriver().shouldNotHave(urlStartingWith(config.getUrl("google.url")));
        log.info("The page CatPage was opened successfully");
        return new CatPageSelenide();
    }
}

package org.pm.ui.google.selenide;

import com.codeborne.selenide.Configuration;
import org.apache.log4j.Logger;
import org.pm.utils.DefaultConfig;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;

public class CatPageSelenide {

    private static final Logger log = Logger.getLogger(CatPageSelenide.class);
    private static DefaultConfig config = DefaultConfig.getInstance();

    public static boolean isOpened() {
        webdriver().shouldNotHave(urlStartingWith(Configuration.baseUrl));
        log.info("The CatPage was opened successfully");
        return true;
    }
}

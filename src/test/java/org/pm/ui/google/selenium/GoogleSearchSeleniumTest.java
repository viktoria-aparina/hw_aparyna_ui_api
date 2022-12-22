package org.pm.ui.google.selenium;

import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.assertTrue;

public class GoogleSearchSeleniumTest extends BaseTest {

    @Test
    public void testDoSearchCheckResult() {
        new GoogleSearchFormPage(driver).open()
                                        .doSearch("Cat")
                                        .chooseAndClickOnPageNumber(2)
                                        .selectById(2);

        assertTrue(new CatPage(driver).isPageOpened(), "The CatPage wasn't opened");
        assertThat(driver.getCurrentUrl()).doesNotContain("https://google.com");
    }
}

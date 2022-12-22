package org.pm.ui.google.selenide;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GoogleSearchSelenideTest {

    @Test
    public void testDoSearchAndVerify() {
        GoogleSearchFormPageSelenide.open()
                                    .doSearch("Cat")
                                    .chooseAndClickOnPageNumber(3)
                                    .selectById(1);

        assertTrue(CatPageSelenide.isOpened(), "Selected link wasn't opened");
    }
}

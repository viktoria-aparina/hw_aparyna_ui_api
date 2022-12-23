package org.pm.ui.google.selenium;

import org.pm.utils.DefaultConfig;
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

    assertThat(driver.getCurrentUrl()).doesNotContain(DefaultConfig.getInstance().getUrl("google.baseUrl"));
    assertTrue(new CatPage(driver).isPageOpened(), "Selected link wasn't opened");
  }
}

package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverManagerTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = WebDriverManagerUtil.getDriver();
    }

    @Test
    public void testWebDriverInitialization() {
        assertNotNull(driver, "Driver should not be null after initialization.");
    }

    @Test
    public void testPageNavigation() {
        driver.get("https://developer.mozilla.org/en-US/docs/Mozilla/Firefox");
        String expectedTitle = "Firefox - Mozilla | MDN";
        assertEquals(expectedTitle, driver.getTitle(), "Page title did not match.");
    }

}

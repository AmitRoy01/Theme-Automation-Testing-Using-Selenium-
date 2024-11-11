package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThemePageTest {
    private static WebDriver driver;
    private static ThemePage themePage;

    @BeforeAll
    public static void setup() {
        driver = WebDriverManagerUtil.getDriver(); // Assuming WebDriverManagerUtil is configured
       // driver.get("https://developer.mozilla.org/en-US/");
        driver.get("https://developer.mozilla.org/en-US/docs/Web/WebDriver");
        themePage = new ThemePage(driver);
    }

    @AfterAll
    public static void tearDown() {
       //WebDriverManagerUtil.quitDriver();
    }

    @Test
    public void testPageTitle() {
        String expectedTitle = "WebDriver | MDN";
        assertEquals(expectedTitle, driver.getTitle(), "Page title should be 'MDN Web Docs'");
    }

    @Test
    public void testSwitchToDarkTheme() {
        themePage.openThemeSwitcherMenu();
        themePage.selectThemeOption("Dark");
        assertTrue(themePage.isThemeApplied("dark"), "Theme should be switched to Dark mode.");
    }

    @Test
    public void testSwitchToLightTheme() {
        themePage.openThemeSwitcherMenu();
        themePage.selectThemeOption("Light");
        assertTrue(themePage.isThemeApplied("light"), "Theme should be switched to Light mode.");
    }

    @Test
    public void testSwitchToDefaultTheme() {
        themePage.openThemeSwitcherMenu();
        themePage.selectThemeOption("OS Default");
        assertTrue(themePage.isThemeApplied("default"), "Theme should be switched to OS Default mode.");
    }

    @Test
    public void testSwitchLightToDark() {
        themePage.openThemeSwitcherMenu();
        themePage.selectThemeOption("Light");
        themePage.openThemeSwitcherMenu();
        themePage.selectThemeOption("Dark");
        assertTrue(themePage.isThemeApplied("dark"), "Theme should be switched to Dark mode.");
    }

    @Test
    public void testSwitchDarkToLight() {
        themePage.openThemeSwitcherMenu();
        themePage.selectThemeOption("Dark");
        themePage.openThemeSwitcherMenu();
        themePage.selectThemeOption("Light");
        assertTrue(themePage.isThemeApplied("light"), "Theme should be switched to Light mode.");
    }

    @Test
    public void testSwitchLightToDefault() {
        themePage.openThemeSwitcherMenu();
        themePage.selectThemeOption("Light");
        themePage.openThemeSwitcherMenu();
        themePage.selectThemeOption("OS Default");
        assertTrue(themePage.isThemeApplied("default"), "Theme should be switched to OS Default mode.");
    }

    @Test
    public void testSwitchDarkToDefault() {
        themePage.openThemeSwitcherMenu();
        themePage.selectThemeOption("Dark");
        themePage.openThemeSwitcherMenu();
        themePage.selectThemeOption("OS Default");
        assertTrue(themePage.isThemeApplied("default"), "Theme should be switched to OS Default mode.");
    }
}

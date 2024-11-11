package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ThemePage {
    private final WebDriver driver;

    private final By themeButton = By.cssSelector("button.theme-switcher-menu");

    public ThemePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openThemeSwitcherMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        long endTime = System.currentTimeMillis() + 15000;

        while (System.currentTimeMillis() < endTime) {
            try {
                WebElement button = driver.findElement(themeButton);
                if (button.isDisplayed() && button.isEnabled()) {
                    button.click();
                    return;
                }
            } catch (Exception e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {
                }
            }
        }
        throw new RuntimeException("Theme switcher button was not clickable within 15 seconds");
    }

    public void selectThemeOption(String themeName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement themeOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li/button[span[contains(text(), '" + themeName + "')]]")));
        themeOption.click();
    }

    public boolean isThemeApplied(String themeClass) {
        long endTime = System.currentTimeMillis() + 15000;
        WebElement htmlTag = driver.findElement(By.tagName("html"));

        while (System.currentTimeMillis() < endTime) {
            String classAttribute = htmlTag.getAttribute("class");
            if (classAttribute != null && classAttribute.contains(themeClass)) {
                return true;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        return false;
    }
}

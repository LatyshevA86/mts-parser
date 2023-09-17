package ru.latyshev.mtsparser.base;

import org.openqa.selenium.WebDriver;
/** Base page class for web driver initialization
 */
public abstract class BasePage {
    protected static WebDriver driver;
    protected static void setWebDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}

package ru.latyshev.mtsparser.base;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected static WebDriver driver;
    protected static void setWebDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}

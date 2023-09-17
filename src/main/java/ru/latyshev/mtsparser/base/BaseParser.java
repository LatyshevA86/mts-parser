package ru.latyshev.mtsparser.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/** Base parser class with init and tear down methods
 */
public abstract class BaseParser {
    WebDriver driver;
    protected BaseParser() {
        setUp();
    }
    protected void setUp() {
        ChromeOptions options = new ChromeOptions().setHeadless(true);
        driver = new ChromeDriver(options);
        BasePage.setWebDriver(driver);
    }
    protected void tearDown(){
        driver.close();
    }
}

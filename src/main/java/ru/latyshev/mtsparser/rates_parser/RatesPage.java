package ru.latyshev.mtsparser.rates_parser;

import org.jsoup.select.Elements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.latyshev.mtsparser.base.BasePage;

import java.util.List;

/** POM class for getting source data with using Selenium
 */
public class RatesPage extends BasePage {
    public static final String URL = "https://moskva.mts.ru/personal/mobilnaya-svyaz/tarifi/vse-tarifi/mobile-tv-inet";
    @FindBy(xpath = "//button[contains(text(), 'Показать ещё')]")
    private WebElement showMoreButton;
    RatesPage() {
        driver.get(URL);
        PageFactory.initElements(driver, this);
    }

    // before getting html code we need to click on button to open more rates
    public String getHtmlSource() {
        showMoreButton.click();
        return driver.getPageSource();
    }
}

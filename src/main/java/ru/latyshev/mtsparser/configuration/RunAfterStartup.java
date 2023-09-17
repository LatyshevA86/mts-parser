package ru.latyshev.mtsparser.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.latyshev.mtsparser.rates_parser.Rate;
import ru.latyshev.mtsparser.rates_parser.RatesParser;
import ru.latyshev.mtsparser.repositories.RateRepository;

import java.util.List;

/** Config class, sets webdriver properties, loads data and saves it
 */
@Component
public class RunAfterStartup{
    @Autowired
    RateRepository repo;
    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        List<Rate> rates = new RatesParser().getRatesFromPage();
        rates.forEach(rate -> repo.save(rate));
    }
}

package ru.latyshev.mtsparser.rates_parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebElement;
import ru.latyshev.mtsparser.base.BaseParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RatesParser extends BaseParser {
    public List<Rate> getRatesFromPage(){
        List<Rate> rates = new ArrayList<>();
        Document doc = Jsoup.parse(new RatesPage().getHtmlSource());
        Elements cards = doc.getElementsByTag("mts-tariff-card");

        for (Element card : cards) {
            String title = card
                    .getElementsByClass("card-title__link").text();
            String cardDescription = card
                    .getElementsByClass("card-description").text();
            String benefits = card
                    .getElementsByClass("benefits-description").text();
            int price = Integer.parseInt(card
                    .getElementsByClass("price-text").first().text().replace(" ", ""));
            String detailsLink = card
                    .getElementsByClass("btn universal-card-button btn_secondary").attr("href");
            List<String> features = card
                    .getElementsByClass("feature-description").stream().map(Element::text).toList();

            String trafficLimit = "";
            String callsLimit = "";
            String connectionSpeed = "";
            String tvChannels = "";
            for (String feature : features) {
                String[] arr = feature.split(" ");
                String key = arr[1];
                if (key.equals("ГБ")) {
                    trafficLimit = feature;
                    continue;
                }
                if (key.equals("минут")) {
                    callsLimit = feature;
                    continue;
                }
                if (key.endsWith("бит/с")) {
                    connectionSpeed = feature;
                    continue;
                }
                if (key.equals("ТВ")) tvChannels = feature;
            }

            rates.add(new Rate(
                    title,
                    cardDescription,
                    trafficLimit,
                    callsLimit,
                    connectionSpeed,
                    tvChannels,
                    benefits,
                    price,
                    detailsLink.startsWith("https://premium.mts.ru")
                            ? detailsLink : !detailsLink.isEmpty()
                                    ? "https://moskva.mts.ru" + detailsLink : RatesPage.URL));
        }

        //TODO after aspect
        tearDown();
        return rates;
    }

}

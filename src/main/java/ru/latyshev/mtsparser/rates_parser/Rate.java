package ru.latyshev.mtsparser.rates_parser;

import lombok.Data;

@Data
public class Rate {
    String title;
    String cardDescription;
    String trafficLimit;
    String callsLimit;
    String connectionSpeed;
    String tvChannels;
    String benefits;
    int price;
    String detailsLink;

    public Rate(String title, String cardDescription, String trafficLimit, String callsLimit, String connectionSpeed, String tvChannels, String benefits, int price, String detailsLink) {
        this.title = title;
        this.cardDescription = cardDescription;
        this.trafficLimit = trafficLimit;
        this.callsLimit = callsLimit;
        this.connectionSpeed = connectionSpeed;
        this.tvChannels = tvChannels;
        this.benefits = benefits;
        this.price = price;
        this.detailsLink = detailsLink;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "title='" + title + '\'' +
                ", cardDescription='" + cardDescription + '\'' +
                ", trafficLimit='" + trafficLimit + '\'' +
                ", callsLimit='" + callsLimit + '\'' +
                ", connectionSpeed='" + connectionSpeed + '\'' +
                ", tvChannels='" + tvChannels + '\'' +
                ", benefits='" + benefits + '\'' +
                ", price=" + price +
                ", detailsLink='" + detailsLink + '\'' +
                '}';
    }
}

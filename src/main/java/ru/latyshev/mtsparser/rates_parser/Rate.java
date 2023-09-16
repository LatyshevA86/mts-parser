package ru.latyshev.mtsparser.rates_parser;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class Rate {
    @Id
    private String title;
    private String cardDescription;
    private String trafficLimit;
    private String callsLimit;
    private String connectionSpeed;
    private String tvChannels;
    private String benefits;
    private String price;
    private String detailsLink;

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

package ru.latyshev.mtsparser.rates_parser;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/** Main parsing entity
 */
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

    public String getTitle() {
        return title;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public String getTrafficLimit() {
        return trafficLimit;
    }

    public String getCallsLimit() {
        return callsLimit;
    }

    public String getConnectionSpeed() {
        return connectionSpeed;
    }

    public String getTvChannels() {
        return tvChannels;
    }

    public String getBenefits() {
        return benefits;
    }

    public String getPrice() {
        return price;
    }

    public String getDetailsLink() {
        return detailsLink;
    }
}

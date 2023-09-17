package ru.latyshev.mtsparser.sorting;

import ru.latyshev.mtsparser.rates_parser.Rate;

import java.util.Comparator;

public class LowSpeedComparator implements Comparator<Rate> {
    @Override
    public int compare(Rate o1, Rate o2) {
        return getSpeedFromString(o1) - getSpeedFromString(o2);
    }
    private int getSpeedFromString(Rate rate) {
        return rate.getConnectionSpeed().isEmpty()
                ? Integer.MAX_VALUE : Integer.parseInt(rate.getConnectionSpeed().split(" ")[0]);
    }
}

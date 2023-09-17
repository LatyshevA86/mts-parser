package ru.latyshev.mtsparser.sorting;

import ru.latyshev.mtsparser.rates_parser.Rate;

import java.util.Comparator;

public class HighSpeedComparator implements Comparator<Rate> {
    @Override
    public int compare(Rate o1, Rate o2) {
        return getSpeedFromString(o2) - getSpeedFromString(o1);
    }
    private int getSpeedFromString(Rate rate) {
        return rate.getConnectionSpeed().isEmpty()
                ? 0 : Integer.parseInt(rate.getConnectionSpeed().split(" ")[0]);
    }
}

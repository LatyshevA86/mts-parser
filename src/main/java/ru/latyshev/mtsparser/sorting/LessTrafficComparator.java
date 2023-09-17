package ru.latyshev.mtsparser.sorting;

import ru.latyshev.mtsparser.rates_parser.Rate;

import java.util.Comparator;

public class LessTrafficComparator implements Comparator<Rate> {
    @Override
    public int compare(Rate o1, Rate o2) {
        return getTrafficLimits(o1) - getTrafficLimits(o2);
    }
    private int getTrafficLimits(Rate rate) {
        String limit = rate.getTrafficLimit();
        return limit.isEmpty() ? Integer.MAX_VALUE : Integer.parseInt(limit.split(" ")[0]);
    }
}

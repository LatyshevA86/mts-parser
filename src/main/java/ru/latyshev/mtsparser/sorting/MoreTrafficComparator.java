package ru.latyshev.mtsparser.sorting;

import ru.latyshev.mtsparser.rates_parser.Rate;

import java.util.Comparator;

public class MoreTrafficComparator implements Comparator<Rate> {
    @Override
    public int compare(Rate o1, Rate o2) {
        return getTrafficLimits(o2) - getTrafficLimits(o1);
    }
    private int getTrafficLimits(Rate rate) {
        String limit = rate.getTrafficLimit();
        return limit.isEmpty() ? 0 : Integer.parseInt(limit.split(" ")[0]);
    }
}

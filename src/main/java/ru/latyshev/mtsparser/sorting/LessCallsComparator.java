package ru.latyshev.mtsparser.sorting;

import ru.latyshev.mtsparser.rates_parser.Rate;

import java.util.Comparator;

public class LessCallsComparator implements Comparator<Rate> {
    @Override
    public int compare(Rate o1, Rate o2) {
        return getCallsLimit(o1) - getCallsLimit(o2);
    }
    private int getCallsLimit(Rate rate) {
        return rate.getCallsLimit().isEmpty()
                ? Integer.MAX_VALUE : Integer.parseInt(rate.getCallsLimit().split(" ")[0]);
    }
}

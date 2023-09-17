package ru.latyshev.mtsparser.sorting;

import ru.latyshev.mtsparser.rates_parser.Rate;

import java.util.Comparator;

public class MoreCallsComparator implements Comparator<Rate> {
    @Override
    public int compare(Rate o1, Rate o2) {
        return getCallsLimit(o2) - getCallsLimit(o1);
    }
    private int getCallsLimit(Rate rate) {
        return rate.getCallsLimit().isEmpty()
                ? 0 : Integer.parseInt(rate.getCallsLimit().split(" ")[0]);
    }
}

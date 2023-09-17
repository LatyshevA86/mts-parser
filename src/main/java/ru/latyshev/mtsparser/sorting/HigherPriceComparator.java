package ru.latyshev.mtsparser.sorting;

import ru.latyshev.mtsparser.rates_parser.Rate;

import java.util.Comparator;

public class HigherPriceComparator implements Comparator<Rate> {
    @Override
    public int compare(Rate o1, Rate o2) {
        return Integer.parseInt(o2.getPrice().replace(" ", ""))
                - Integer.parseInt(o1.getPrice().replace(" ", ""));
    }
}

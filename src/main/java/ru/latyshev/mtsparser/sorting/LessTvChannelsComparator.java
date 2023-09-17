package ru.latyshev.mtsparser.sorting;

import ru.latyshev.mtsparser.rates_parser.Rate;

import java.util.Comparator;

public class LessTvChannelsComparator implements Comparator<Rate> {
    @Override
    public int compare(Rate o1, Rate o2) {
        return getTvChannels(o1) - getTvChannels(o2);
    }
    private int getTvChannels(Rate rate){
        String channels = rate.getTvChannels();
        return channels.isEmpty() ? Integer.MAX_VALUE : Integer.parseInt(channels.split(" ")[0]);
    }
}

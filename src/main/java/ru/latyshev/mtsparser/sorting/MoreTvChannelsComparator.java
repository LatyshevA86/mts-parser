package ru.latyshev.mtsparser.sorting;

import ru.latyshev.mtsparser.rates_parser.Rate;

import java.util.Comparator;

public class MoreTvChannelsComparator implements Comparator<Rate> {
    @Override
    public int compare(Rate o1, Rate o2) {
        return getTvChannels(o2) - getTvChannels(o1);
    }
    private int getTvChannels(Rate rate){
        String channels = rate.getTvChannels();
        return channels.isEmpty() ? 0 : Integer.parseInt(channels.split(" ")[0]);
    }
}

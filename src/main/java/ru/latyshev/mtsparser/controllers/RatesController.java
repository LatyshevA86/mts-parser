package ru.latyshev.mtsparser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.latyshev.mtsparser.rates_parser.Rate;
import ru.latyshev.mtsparser.rates_parser.RatesParser;
import ru.latyshev.mtsparser.repositories.RateRepositiry;
import ru.latyshev.mtsparser.sorting.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


@Controller()
public class RatesController {
    private RateRepositiry repo;
    private Map<String, Comparator<Rate>> map = Map.of(
            "cheapPrice", new CheapPriceComparator(),
            "highPrice", new HigherPriceComparator(),
            "lowSpeed", new LowSpeedComparator(),
            "highSpeed", new HighSpeedComparator(),
            "moreCalls", new MoreCallsComparator(),
            "lessCalls", new LessCallsComparator(),
            "moreTraffic", new MoreTrafficComparator(),
            "lessTraffic", new LessTrafficComparator(),
            "moreTvChannels", new MoreTvChannelsComparator(),
            "lessTvChannels", new LessTvChannelsComparator()
    );
    public RatesController(RateRepositiry repositiry) {
        this.repo = repositiry;
    }
    @GetMapping("/")
    public String getMtsRates(Model model) {
        model.addAttribute("rates", repo.findAll());
        return "index";
    }
    @PostMapping("/")
    public String parse(Model model) {
        new RatesParser().getRatesFromPage().forEach(rate -> repo.save(rate));
        model.addAttribute("rates", repo.findAll());
        return "redirect:/";
    }
    @PostMapping("/sort")
    public String sort(@RequestParam(value = "comparator", required = false) String comparator, Model model) {
        List<Rate> rates = (List<Rate>) repo.findAll();
        rates.sort(map.get(comparator));
        model.addAttribute("rates", rates);
        return "index";
    }


}

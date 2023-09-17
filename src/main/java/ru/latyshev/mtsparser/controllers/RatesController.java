package ru.latyshev.mtsparser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.latyshev.mtsparser.rates_parser.Rate;
import ru.latyshev.mtsparser.rates_parser.RatesParser;
import ru.latyshev.mtsparser.repositories.RateRepository;
import ru.latyshev.mtsparser.sorting.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/** Main controller
 */
@Controller()
public class RatesController {
    private RateRepository repo;

    // map of sorting strategies
    //TODO make class with static constants
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
    public RatesController(RateRepository repository) {
        this.repo = repository;
    }

    // load data from database
    @GetMapping("/")
    public String getMtsRates(Model model) {
        model.addAttribute("rates", repo.findAll());
        return "index";
    }

    // source parsing and saving data in database
    @PostMapping("/")
    public String parse(Model model) {
        new RatesParser().getRatesFromPage().forEach(rate -> repo.save(rate));
        model.addAttribute("rates", repo.findAll());
        // TODO check returning value "index"
        return "redirect:/";
    }

    // data sort with using comparators
    @PostMapping("/sort")
    public String sort(@RequestParam(value = "comparator", required = false) String comparator, Model model) {
        List<Rate> rates = (List<Rate>) repo.findAll();
        // TODO use constants instead of map values
        rates.sort(map.get(comparator));
        model.addAttribute("rates", rates);
        return "index";
    }


}

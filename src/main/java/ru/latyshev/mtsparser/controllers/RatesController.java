package ru.latyshev.mtsparser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.latyshev.mtsparser.rates_parser.Rate;
import ru.latyshev.mtsparser.rates_parser.RatesParser;
import ru.latyshev.mtsparser.repositories.RateRepositiry;

import java.util.List;


@Controller()
public class RatesController {
    private RateRepositiry repo;
    public RatesController(RateRepositiry repositiry) {
        this.repo = repositiry;
    }
    @GetMapping("/")
    public String getMtsRates(Model model) {
//        model.addAttribute("rates", new RatesParser().getRatesFromPage());

        model.addAttribute("rates", repo.findAll());
        return "index";
    }

}

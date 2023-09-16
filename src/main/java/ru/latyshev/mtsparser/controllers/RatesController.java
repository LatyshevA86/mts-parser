package ru.latyshev.mtsparser.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.latyshev.mtsparser.configuration.RunAfterStartup;
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
        model.addAttribute("rates", repo.findAll());
        return "index";
    }
    @PostMapping
    public String parse(Model model) {
        new RatesParser().getRatesFromPage().forEach(rate -> repo.save(rate));
        model.addAttribute("rates", repo.findAll());
        return "redirect:/";
    }


}

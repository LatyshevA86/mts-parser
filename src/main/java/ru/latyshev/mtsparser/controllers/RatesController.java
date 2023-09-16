package ru.latyshev.mtsparser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.latyshev.mtsparser.rates_parser.Rate;
import ru.latyshev.mtsparser.rates_parser.RatesParser;

import java.util.List;


@Controller()
public class RatesController {
    @GetMapping("/")
    public String getMtsRates(Model model) {
        model.addAttribute("rates", new RatesParser().getRatesFromPage());
        return "index";
    }

}

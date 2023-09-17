package ru.latyshev.mtsparser.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.latyshev.mtsparser.rates_parser.Rate;

@Repository
public interface RateRepository extends CrudRepository<Rate, String> {
}

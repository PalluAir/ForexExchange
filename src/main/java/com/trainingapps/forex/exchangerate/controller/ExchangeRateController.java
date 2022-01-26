package com.trainingapps.forex.exchangerate.controller;

import java.util.List;

import com.trainingapps.forex.exchangerate.dto.ExchangerateRequest;
import com.trainingapps.forex.exchangerate.dto.ExchangerateResponse;
import com.trainingapps.forex.exchangerate.entity.ExchangeValue;
import com.trainingapps.forex.exchangerate.repository.ExchangeValueRepository;
import com.trainingapps.forex.exchangerate.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/exchangerate")
public class ExchangeRateController {

    @Autowired
    private ExchangeValueRepository repository;

    @Autowired
    private ExchangeService exchangeService;

    @PostMapping("/create")
    public ExchangerateResponse create(@RequestBody ExchangerateRequest exchangeRate){

        return exchangeService.create(exchangeRate);
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

        ExchangeValue exchangeValue = exchangeService.retrieveExchangeValue(from, to);

        return exchangeValue;
    }



    @PutMapping("/update")
    public ExchangerateResponse update(@RequestBody ExchangerateRequest exchangeRate, Long id) {

        return exchangeService.update(exchangeRate, id);

    }

    @GetMapping("/viewone/{exchangeRateId}")
    public ExchangerateResponse viewOne(@PathVariable Long exchangeRateId){

        return exchangeService.viewOne(exchangeRateId);
    }

    @GetMapping("/viewall")
    public List<ExchangerateResponse> viewAll(){

        return exchangeService.viewAll();
    }

    @DeleteMapping("/delete/{exchangeRateId}")
    public void delete(@PathVariable Long exchangeRateId) {

        exchangeService.delete(exchangeRateId);
    }

}


package com.trainingapps.forex.exchangerate.service;

import com.trainingapps.forex.exchangerate.dto.ExchangerateRequest;
import com.trainingapps.forex.exchangerate.dto.ExchangerateResponse;
import com.trainingapps.forex.exchangerate.entity.ExchangeValue;
import com.trainingapps.forex.exchangerate.exceptions.ExchangeValueIdNotFoundException;
import com.trainingapps.forex.exchangerate.repository.ExchangeValueRepository;
import com.trainingapps.forex.exchangerate.util.ExchangeRateUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ExchangeService {

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @Autowired
    private ExchangeRateUtility exchangeRateUtility;

    public ExchangerateResponse create(ExchangerateRequest exchangeRate){
        log.info("Inside create method of ExchangeService");
        ExchangeValue exchangeValue = new ExchangeValue();
        exchangeValue.setFrom(exchangeRateUtility.toCurrencyEnum(exchangeRate.getFrom()));
        exchangeValue.setTo(exchangeRateUtility.toCurrencyEnum(exchangeRate.getTo()));
        exchangeValue.setConversionMultiple(exchangeRate.getConversionMultiple());
        exchangeValueRepository.save(exchangeValue);
        return exchangeRateUtility.toExchangeRateDetails(exchangeValue);
    }

    public ExchangerateResponse update(ExchangerateRequest exchangeRate, Long id) {
        log.info("Inside update of ExchangeService");
        ExchangeValue exchangeValue = findById(id);
        exchangeValue.setId(id);
        exchangeValue.setFrom(exchangeRateUtility.toCurrencyEnum(exchangeRate.getFrom()));
        exchangeValue.setTo(exchangeRateUtility.toCurrencyEnum(exchangeRate.getTo()));
        exchangeValue.setConversionMultiple(exchangeRate.getConversionMultiple());

        exchangeValueRepository.save(exchangeValue);
        return exchangeRateUtility.toExchangeRateDetails(exchangeValue);

    }

    public ExchangeValue findById(Long exchangeRateId) {
        Optional<ExchangeValue> optional = exchangeValueRepository.findById(exchangeRateId);
        if (!optional.isPresent()) {
            throw new ExchangeValueIdNotFoundException("Exchange value Not Found for id= " + exchangeRateId);
        }
        return optional.get();
    }

    public ExchangerateResponse viewOne(Long exchangeRateId){
        log.info("Inside viewOne method of ExchangeService");
        ExchangeValue exchangeValue = findById(exchangeRateId);
        return exchangeRateUtility.toExchangeRateDetails(exchangeValue);
    }

    public List<ExchangerateResponse> viewAll(){
        log.info("Inside viewAll method of ExchangeService");
        List<ExchangeValue> exchangeValue = exchangeValueRepository.findAll();
        return exchangeRateUtility.toExchangeRateDetailsList(exchangeValue);

    }

    public void delete(Long exchangeRateId) {
        log.info("Inside delete method of ExchangeService");
        exchangeValueRepository.deleteById(exchangeRateId);
    }

    public ExchangeValue retrieveExchangeValue(String from, String to) {

        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(exchangeRateUtility.toCurrencyEnum(from), exchangeRateUtility.toCurrencyEnum(to));

        return exchangeValue;
    }

}


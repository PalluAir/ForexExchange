package com.trainingapps.forex.exchangerate.util;

import com.trainingapps.forex.exchangerate.dto.ExchangerateResponse;
import com.trainingapps.forex.exchangerate.entity.CurrencyEnum;
import com.trainingapps.forex.exchangerate.entity.ExchangeValue;
import com.trainingapps.forex.exchangerate.exceptions.CurrencyNotAvailableException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExchangeRateUtility {
    public ExchangerateResponse toExchangeRateDetails(ExchangeValue exchangeValue) {

        ExchangerateResponse exchangerateResponse = new ExchangerateResponse();
        exchangerateResponse.setId(exchangeValue.getId());
        exchangerateResponse.setFrom(exchangeValue.getFrom().name());
        exchangerateResponse.setTo(exchangeValue.getTo().name());
        exchangerateResponse.setConversionMultiple(exchangeValue.getConversionMultiple());

        return exchangerateResponse;
    }

    public List<ExchangerateResponse> toExchangeRateDetailsList(List<ExchangeValue> exchangeValues) {

        return exchangeValues.stream().map(exchangeValue -> toExchangeRateDetails(exchangeValue)).collect(Collectors.toList());

    }

    public CurrencyEnum toCurrencyEnum(String currencyText) {
        CurrencyEnum[] values = CurrencyEnum.values();
        for (CurrencyEnum type : values) {
            String currencytype = type.name();
            if (currencytype.equalsIgnoreCase(currencyText)) {
                return type;
            }
        }
        throw new CurrencyNotAvailableException("Conversion to '"+currencyText + "' is Invalid / Not Available");

    }
}


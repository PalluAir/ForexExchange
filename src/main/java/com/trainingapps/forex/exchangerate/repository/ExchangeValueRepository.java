package com.trainingapps.forex.exchangerate.repository;

import com.trainingapps.forex.exchangerate.entity.CurrencyEnum;
import com.trainingapps.forex.exchangerate.entity.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
    ExchangeValue findByFromAndTo(CurrencyEnum from, CurrencyEnum to);

    ExchangeValue findExchangeValueById(Long id);
}

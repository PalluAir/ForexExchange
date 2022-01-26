package com.trainingapps.forex.exchangerate.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class ExchangeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "Id cannot be null")
    private Long id;

    @Column(name="currency_from")
    @NotBlank(message= "Add currency from")
    @NotNull(message="Currency from cannot be Null")
    private CurrencyEnum from;

    @Column(name="currency_to")
    @NotBlank(message= "Add currency to")
    @NotNull(message= "Currency To cannot be Null")
    private CurrencyEnum to;

//    @NotBlank(message = "ConversionMultiple")
    @Column(name = "conversionMultiple")
    private double conversionMultiple;

    public ExchangeValue(){

    }

    public ExchangeValue(Long id, CurrencyEnum from, CurrencyEnum to, double conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CurrencyEnum getFrom() {
        return from;
    }

    public void setFrom(CurrencyEnum from) {
        this.from = from;
    }

    public CurrencyEnum getTo() {
        return to;
    }

    public void setTo(CurrencyEnum to) {
        this.to = to;
    }

    public double getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(double conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    @Override
    public String toString() {
        return "ExchangeValue{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                ", conversionMultiple=" + conversionMultiple +
                '}';
    }
}

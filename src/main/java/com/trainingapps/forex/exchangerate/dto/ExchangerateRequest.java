package com.trainingapps.forex.exchangerate.dto;




public class ExchangerateRequest {

    private String from;
    private String to;
    private double conversionMultiple;

    public ExchangerateRequest(){

    }

    public ExchangerateRequest(String from, String to, double conversionMultiple) {
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(double conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }
}

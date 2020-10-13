package demo.web.app.beans;

import java.math.BigDecimal;

public class CurrencyExchangeBean {
    private int id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal conversionMultiple;
    private int port;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfromCurrency() {
        return fromCurrency;
    }

    public void setfromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String gettoCurrency() {
        return toCurrency;
    }

    public void settoCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public CurrencyExchangeBean(int id, String fromCurrency, String toCurrency, BigDecimal conversionMultiple) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionMultiple = conversionMultiple;
    }

    public CurrencyExchangeBean() {
    }


}

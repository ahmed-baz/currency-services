package demo.web.app.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.persistence.Table;
import java.math.BigDecimal;


@Entity
@Table(name = "Currency_Exchange"
        , catalog = "app"
)
public class CurrencyExchangeModel {
    private int id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal conversionMultiple;

    public CurrencyExchangeModel() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "fromCurrency", unique = false, nullable = false)
    public String getfromCurrency() {
        return fromCurrency;
    }

    public void setfromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    @Column(name = "toCurrency", unique = false, nullable = false)
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

    public CurrencyExchangeModel(int id, String fromCurrency, String toCurrency, BigDecimal conversionMultiple) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionMultiple = conversionMultiple;
    }
}

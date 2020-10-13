package demo.web.app.beans;

import org.springframework.beans.factory.annotation.Value;


public class CurrencyCalculationBean {
    public CurrencyCalculationBean(int id, String from, String to, int conversionMultiple, int quantity, double total, int port) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.total = total;
        this.port = port;
    }

    private int id;
    private String from;
    private String to;
    private int conversionMultiple;
    private int quantity;
    private double total;
    private int port;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public int getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(int conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public CurrencyCalculationBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public CurrencyCalculationBean(int id, String from, String to, int conversionMultiple, int quantity, double total) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.total = total;
    }
}

package demo.web.app.service;

import com.google.gson.Gson;
import demo.web.app.beans.CurrencyCalculationBean;
import demo.web.app.beans.CurrencyExchangeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyConverterService {
    @Autowired
    private CurrencyConverterServiceProxy serviceProxy;

    public CurrencyCalculationBean getCurrencyExchangeService(String from, String to, int quantity) {
        CurrencyExchangeBean currencyExchangeBean = getCurrencyExchangeBean(from, to);
        int id = currencyExchangeBean.getId();
        int conversionMultiple = currencyExchangeBean.getConversionMultiple();
        int port = currencyExchangeBean.getPort();
        double total = CalculatConversionMultiple(conversionMultiple, quantity);
        CurrencyCalculationBean currencyCalculationBean = new CurrencyCalculationBean(id, from, to, conversionMultiple, quantity, total, port);
        return currencyCalculationBean;
    }

    public CurrencyCalculationBean getCurrencyExchangeServiceFeign(String from, String to, int quantity) {
        CurrencyExchangeBean currencyExchangeValue = serviceProxy.getCurrencyExchangeValue(from, to);
        int id = currencyExchangeValue.getId();
        int conversionMultiple = currencyExchangeValue.getConversionMultiple();
        int port = currencyExchangeValue.getPort();
        double total = CalculatConversionMultiple(conversionMultiple, quantity);
        CurrencyCalculationBean currencyCalculationBean = new CurrencyCalculationBean(id, from, to, conversionMultiple, quantity, total, port);
        return currencyCalculationBean;
    }

    public CurrencyExchangeBean getCurrencyExchangeBean(String from, String to) {
        CurrencyExchangeBean currencyExchangeBean = new CurrencyExchangeBean();
        Gson gson = new Gson();
        final String uri = "http://127.0.0.1:8180/currency-exchange/from/{from}/to/{to}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("from", from);
        params.put("to", to);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class, params);
        currencyExchangeBean = gson.fromJson(result.getBody(), CurrencyExchangeBean.class);
        return currencyExchangeBean;
    }

    public double CalculatConversionMultiple(int conversionMultiple, int quantity) {
        return conversionMultiple * quantity;
    }
}

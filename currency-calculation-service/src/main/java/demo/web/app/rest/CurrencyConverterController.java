package demo.web.app.rest;

import demo.web.app.beans.CurrencyCalculationBean;
import demo.web.app.service.CurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
public class CurrencyConverterController {
    @Autowired
    private CurrencyConverterService converterService;
    @Autowired
    private Environment environment;

    @GetMapping("/currency-converter/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public CurrencyCalculationBean getCurrencyCalculation(@PathVariable String fromCurrency, @PathVariable String toCurrency, @PathVariable int quantity) {
        CurrencyCalculationBean bean = converterService.getCurrencyExchangeService(fromCurrency, toCurrency, quantity);
        String portStr = environment.getProperty("local.server.port");
        //bean.setPort(Integer.valueOf(portStr));
        return bean;
    }

    @GetMapping("/currency-converter-feign/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public CurrencyCalculationBean getCurrencyCalculationFeign(@PathVariable String fromCurrency, @PathVariable String toCurrency, @PathVariable int quantity) {
        CurrencyCalculationBean bean = converterService.getCurrencyExchangeServiceFeign(fromCurrency, toCurrency, quantity);
        String portStr = environment.getProperty("local.server.port");
        //bean.setPort(Integer.valueOf(portStr));
        return bean;
    }
}

package demo.web.app.rest;

import demo.web.app.beans.CurrencyExchangeBean;
import demo.web.app.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyExchangeController {
    @Autowired
    private CurrencyExchangeService exchangeService;
    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
    public CurrencyExchangeBean getCurrencyExchangeValue(@PathVariable String fromCurrency, @PathVariable String toCurrency) {
        CurrencyExchangeBean bean = exchangeService.getCurrencyExchangeService(fromCurrency, toCurrency);
        String portStr = environment.getProperty("local.server.port");
        bean.setPort(Integer.valueOf(portStr));
        return bean;
    }
}

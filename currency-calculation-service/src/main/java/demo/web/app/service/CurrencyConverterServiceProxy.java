package demo.web.app.service;

import demo.web.app.beans.CurrencyCalculationBean;
import demo.web.app.beans.CurrencyExchangeBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "127.0.0.1:8082")
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service") // Ribbon Load Balancing
public interface CurrencyConverterServiceProxy {
    //@GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
    @GetMapping("/currency-exchange-service/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
    public CurrencyExchangeBean getCurrencyExchangeValue(@PathVariable String fromCurrency, @PathVariable String toCurrency);
}

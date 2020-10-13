package demo.web.app.service;

import demo.web.app.beans.CurrencyExchangeBean;
import demo.web.app.model.CurrencyExchangeModel;
import demo.web.app.repo.CurrencyExchangeRepo;
import demo.web.app.transformer.CurrencyExchangeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyExchangeService {
    @Autowired
    private CurrencyExchangeRepo exchangeRepo;
    @Autowired
    private CurrencyExchangeTransformer transformer;

    public CurrencyExchangeBean getCurrencyExchangeService(String from, String to) {
        CurrencyExchangeModel exchangeModel = exchangeRepo.findOneByFromCurrencyIsAndToCurrencyIs(from, to);
        CurrencyExchangeBean currencyExchangeBean = transformer.fromEntityToBean(exchangeModel);
        return currencyExchangeBean;
    }
}

package demo.web.app.repo;

import demo.web.app.model.CurrencyExchangeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchangeModel, Integer> {
    public CurrencyExchangeModel findOneByFromCurrencyIsAndToCurrencyIs(String from,String to);
}

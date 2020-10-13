package demo.web.app.transformer;

import demo.web.app.beans.CurrencyExchangeBean;
import demo.web.app.model.CurrencyExchangeModel;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeTransformer implements CommonTransformer<CurrencyExchangeModel, CurrencyExchangeBean> {
    @Override
    public CurrencyExchangeBean fromEntityToBean(CurrencyExchangeModel entity) {
        CurrencyExchangeBean bean = new DozerBeanMapper().map(entity, CurrencyExchangeBean.class);
        return bean;
    }

    @Override
    public CurrencyExchangeModel fromBeanToEntity(CurrencyExchangeBean bean) {
        CurrencyExchangeModel entity = new DozerBeanMapper().map(bean, CurrencyExchangeModel.class);
        return entity;
    }
}

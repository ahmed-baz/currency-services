package demo.web.app.transformer;

import demo.web.app.beans.CurrencyExchangeBean;
import demo.web.app.model.CurrencyExchangeModel;

public interface CommonTransformer<Entity, Bean> {
    public Bean fromEntityToBean(Entity entity);

    public Entity fromBeanToEntity(Bean bean);
}

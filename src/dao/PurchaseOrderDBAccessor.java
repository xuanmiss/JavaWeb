package dao;

import entity.Purchase_Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LCQ on 2017/5/7.
 */
@Repository("purchaseOrderDBAcc")
public class PurchaseOrderDBAccessor extends BaseDBAccessor<Purchase_Order> implements IPurchaseOrderDBAccessor{
    @Override
    public List<Purchase_Order> getListByPageOrderByDate(int pageNo, int rows) {
        return getSession().createQuery("from entity.Purchase_Order order by date")
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public List<Purchase_Order> getUndoPurchaseByPage(int pageNo, int rows) {
        return getSession().createQuery("select po from entity.Purchase_Order as po where po.type = 1 or po.type = 3")
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public int countOfUndoPurchase() {
        return ((Long)getSession().createQuery("select count(*) from entity.Purchase_Order as po where po.type = 1 or po.type = 3")
                .uniqueResult()).intValue();
    }

    @Override
    public void setPurchaseOrderType(Purchase_Order order) {
        order.setType(order.getType()+2);
    }
}

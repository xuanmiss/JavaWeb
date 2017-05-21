package dao;

import entity.Purchase_Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LCQ on 2017/5/7.
 */
@Repository("purchaseOrderDBAcc")
public class PurchaseOrderDBAccessor extends BaseDBAccessor<Purchase_Order>
        implements IPurchaseOrderDBAccessor{
    @Override
    public List<Purchase_Order> getListByPageOrderByDate(int pageNo, int rows) {
        return getSession().createQuery("from Purchase_Order order by date")
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public List<Purchase_Order> findByOrderNo(Object object) {
        return null;
    }

    @Override
    public List<Purchase_Order> findByClerk(Object object) {
        return null;
    }

    @Override
    public List<Purchase_Order> findByDate(Object object) {
        return null;
    }


    @Override
    public List<Purchase_Order> findByModel(Object object) {
        return null;
    }
}

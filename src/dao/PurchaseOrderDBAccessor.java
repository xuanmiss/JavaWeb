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

    /**
     * 根据订单号查询预购表
     *
     * @param order
     */
    @Override
    public void setPurchaseOrderType(Purchase_Order order) {
        order.setType(order.getType()+2);
    }

}

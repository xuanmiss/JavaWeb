package service.finance;

import entity.Purchase_Order;
import util.PageBean;

/**
 * Created by chenshihong on 2017/5/21.
 */
public interface IPurchaseOrderHandleSvc {
    PageBean<Purchase_Order> getListByPage(int pageNo);
    void setPurchaseOrderType(Purchase_Order order);
    Purchase_Order findById(int id);
    void updatePurchaseOrder(Purchase_Order order);
}

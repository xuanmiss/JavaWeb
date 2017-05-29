package service.finance;

import entity.Purchase;
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
    PageBean<Purchase_Order> getListByBrandAndModelDesc(int brandId, int modelId, int pageNo);
    PageBean<Purchase_Order> getListByBrandAndModelAsc(int brandId, int modelId, int pageNo);
    PageBean<Purchase_Order> getListByBrandDesc(int brandId, int pageNo);
    PageBean<Purchase_Order> getListByBrandAsc(int brandId, int pageNo);
    PageBean<Purchase_Order> getListByDesc(int pageNo);
    PageBean<Purchase_Order> getListByAsc(int pageNo);
}

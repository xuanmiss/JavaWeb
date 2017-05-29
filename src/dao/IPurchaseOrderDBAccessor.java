package dao;

import entity.Purchase_Order;
import util.PageBean;

import java.util.List;

/**
 * Created by LCQ on 2017/5/7.
 */
public interface IPurchaseOrderDBAccessor  extends IBaseDBAccessor<Purchase_Order> {

    List<Purchase_Order> getListByPageOrderByDate(int pageNo, int rows);

    List<Purchase_Order> getUndoPurchaseByPage(int pageNo,int rows);
    int countOfUndoPurchase();
    void setPurchaseOrderType(Purchase_Order order);
    Purchase_Order getOrderByOrderNo(String orderNo);

    List<Purchase_Order> getListByBrandAndModelDesc(int brandId, int modelId, int pageNo, int rows);
    List<Purchase_Order> getListByBrandAndModelAsc(int brandId, int modelId, int pageNo ,int rows);
    List<Purchase_Order> getListByBrandDesc(int brandId, int pageNo, int rows);
    List<Purchase_Order> getListByBrandAsc(int brandId, int pageNo, int rows);
    List<Purchase_Order> getListByDesc(int pageNo, int rows);
    List<Purchase_Order> getListByAsc(int pageNo, int rows);

}

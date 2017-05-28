package dao;

import entity.Purchase_Order;

import java.util.List;

/**
 * Created by LCQ on 2017/5/7.
 */
public interface IPurchaseOrderDBAccessor  extends IBaseDBAccessor<Purchase_Order> {

    List<Purchase_Order> getListByPageOrderByDate(int pageNo, int rows);

    List<Purchase_Order> getUndoPurchaseByPage(int pageNo,int rows);
    int countOfUndoPurchase();
    void setPurchaseOrderType(Purchase_Order order);

}

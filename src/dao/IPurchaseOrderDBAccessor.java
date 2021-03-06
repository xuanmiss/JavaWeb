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

    List<Purchase_Order> getUndoListByBrandAndModelDesc(int brandId, int modelId, int pageNo, int rows);
    List<Purchase_Order> getUndoListByBrandAndModelAsc(int brandId, int modelId, int pageNo , int rows);
    List<Purchase_Order> getUndoListByBrandDesc(int brandId, int pageNo, int rows);
    List<Purchase_Order> getUndoListByBrandAsc(int brandId, int pageNo, int rows);
    List<Purchase_Order> getUndoListByDesc(int pageNo, int rows);
    List<Purchase_Order> getUndoListByAsc(int pageNo, int rows);
    int getUndoCountByBrand(int brandId);
    int getUndoCountByBrandAndModel(int brandId, int modelId);
    int getUndoCountByModel(int modelId);

}

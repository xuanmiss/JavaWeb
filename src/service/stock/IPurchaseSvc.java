package service.stock;

import entity.*;
import util.PageBean;

import java.util.List;


public interface IPurchaseSvc {
    PageBean<Purchase> getListByPage(int pageNo);
    List<Batch> getAllBatch();
    List<Clerk> getAllClerk();
    List<Order> getAllOrder();
    void savePurchase(Purchase purchase);
    void remove(int id);
    boolean addPurchaseOrder(Purchase_Order po);
    PageBean<Purchase_Order> getUndoPurchaseOrders(int pageNo);
    void inWarehouse(Purchase purchase);
    boolean cancelIn(Purchase_Order po);

    PageBean<Purchase_Order> getListByBrandAndModelDesc(int brandId, int modelId, int pageNo);
    PageBean<Purchase_Order> getListByBrandAndModelAsc(int brandId, int modelId, int pageNo);
    PageBean<Purchase_Order> getListByBrandDesc(int brandId, int pageNo);
    PageBean<Purchase_Order> getListByBrandAsc(int brandId, int pageNo);
    PageBean<Purchase_Order> getListByDesc(int pageNo);
    PageBean<Purchase_Order> getListByAsc(int pageNo);
}

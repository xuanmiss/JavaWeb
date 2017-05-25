package service.stock;

import entity.Batch;
import entity.Clerk;
import entity.Order;
import entity.Purchase;
import util.PageBean;

import java.util.List;

/**
 * Created by LCQ on 2017/5/23.
 */
public interface IPurchaseSvc {
    PageBean<Purchase> getAll(int pageNo);
    List<Batch> getAllBatch();
    List<Clerk> getAllClerk();
    List<Order> getAllOrder();
    void savePurchase(Purchase purchase);
    void remove(int id);
}

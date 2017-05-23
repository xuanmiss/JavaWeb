package dao;

import entity.Batch;
import entity.Clerk;
import entity.Order;

import java.util.List;

/**
 * Created by ymcvalu on 2017/5/22.
 */
public interface IPurchaseDBAccessor {
    List<Batch> getBatchList();
    List<Clerk> getClerkList();
    List<Order> getOrderList();
    void remove(int id);
}

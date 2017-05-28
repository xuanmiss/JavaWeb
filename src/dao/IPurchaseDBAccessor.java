package dao;

import entity.*;

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

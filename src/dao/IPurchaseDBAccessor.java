package dao;

import entity.Purchase;

import java.util.List;

/**
 * Created by LCQ on 2017/5/7.
 */
public interface IPurchaseDBAccessor  extends IBaseDBAccessor<Purchase>{
    /**
     *查找相应购入表
     */
    List<Purchase> findByBatch(Object object);
    /**
     *根据业务员查看购入表
     */
    List<Purchase> findByClerk(Object object);
    /**
     *根据订单号查询购入表
     */
    List<Purchase> findByOrderNo(Object object);
}

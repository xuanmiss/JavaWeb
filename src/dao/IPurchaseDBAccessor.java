package dao;

import java.util.List;

/**
 * Created by LCQ on 2017/5/7.
 */
public interface IPurchaseDBAccessor<T> extends IBaseDBAccessor<T>{
    /**
     *查找相应购入表
     */
    List<T> findByBatch(Object object);
    /**
     *根据业务员查看购入表
     */
    List<T> findByClerk(Object object);
    /**
     *根据订单号查询购入表
     */
    List<T> findByOrderNo(Object object);
}

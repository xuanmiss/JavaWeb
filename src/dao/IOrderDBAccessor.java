package dao;

import java.util.List;

/**
 * Created by LCQ on 2017/5/7.
 */
public interface IOrderDBAccessor<T> extends IBaseDBAccessor<T>{
    /**
     *查询所有订单
     */
    List<T> findAll();
    /**
     *根据日期查找订单
     */
    List<T> findByDate(Object object);
    /**
     * 按客户名称查找订单
     */
    List<T> findByName(Object object);
    /**
     * 按订单号查询订单
     */
    Class<T> findByOrderNo(Object object);
    /**
     * 按订单状态查询订单
     */
    List<T> findByStatus(Object object);
    /**
     *根据瓷砖型号查询订购表
     **/
    List<T> findByModel(Object object);
}

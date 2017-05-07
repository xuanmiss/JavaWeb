package dao;

import entity.Order;

import java.util.List;

/**
 * Created by LCQ on 2017/5/7.
 */
public interface IOrderDBAccessor extends IBaseDBAccessor<Order>{
    /**
     *
     *查询所有订单
     */
    List<Order> findAll();
    /**
     *根据日期查找订单
     */
    List<Order> findByDate(Object object);
    /**
     * 按客户名称查找订单
     */
    List<Order> findByName(Object object);
    /**
     * 按订单号查询订单
     */
    Class<Order> findByOrderNo(Object object);
    /**
     * 按订单状态查询订单
     */
    List<Order> findByStatus(Object object);
    /**
     *根据瓷砖型号查询订购表
     **/
    List<Order> findByModel(Object object);
}

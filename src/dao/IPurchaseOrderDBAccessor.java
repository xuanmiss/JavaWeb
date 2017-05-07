package dao;

import entity.Purchase_Order;

import java.util.List;

/**
 * Created by LCQ on 2017/5/7.
 */
public interface IPurchaseOrderDBAccessor  extends IBaseDBAccessor<Purchase_Order> {
    /**
     * 根据订单号查询预购表
     */
    List<Purchase_Order> findByOrderNo(Object object);
    /**
     *
     *根据业务员查看预购表
     */
    List<Purchase_Order> findByClerk(Object object);
    /**
     * 按日期查找订单
     */
    List<Purchase_Order> findByDate(Object object);
    /**
     *根据瓷砖型号查询预购表
     **/
    List<Purchase_Order> findByModel(Object object);
}

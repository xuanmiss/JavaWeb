package dao;

import java.util.List;

/**
 * Created by LCQ on 2017/5/7.
 */
public interface IPurchaseOrderDBAccessor<T> extends IBaseDBAccessor<T> {
    /**
     * 根据订单号查询预购表
     */
    List<T> findByOrderNo(Object object);
    /**
     *根据业务员查看预购表
     */
    List<T> findByClerk(Object object);
    /**
     * 按日期查找订单
     */
    List<T> findByDate(Object object);
    /**
     *根据瓷砖型号查询预购表
     **/
    List<T> findByModel(Object object);
}

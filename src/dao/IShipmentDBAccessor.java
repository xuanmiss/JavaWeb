package dao;

import entity.Shipment;

import java.util.List;

/**
 * Created by Administrator on 2017/5/7.
 */
/**
 * 公司出货单接口
 */
public interface IShipmentDBAccessor extends IBaseDBAccessor<Shipment>{
    /**
     * 声明新方法
     * ...
     */

    /**
     * 根据订单查找出货单
     * @return List<Shipment>
     */
    List<Shipment> findByOrder_form(Object object);

    /**
     * 根据业务员ID查找出货单
     * @return List<Shipment>
     */
    List<Shipment> findByClerk(Object object);

    /**
     * 根据批次查找出货单
     * @return List<Shipment>
     */
    List<Shipment> findByBatch(Object object);
}

package dao;

import entity.Shipment;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/7.
 */

/**
 * 公司出货单实现类
 * ...
 */
@Repository("shipmentsDBA")
@Lazy
public class ShipmentDBAccessor extends BaseDBAccessor<Shipment> implements IShipmentDBAccessor{

    @Override
    public List<Shipment> findByOrder_form(Object object) {
        return null;
    }

    @Override
    public List<Shipment> findByClerk(Object object) {
        return null;
    }

    @Override
    public List<Shipment> findByBatch(Object object) {
        return null;
    }


}

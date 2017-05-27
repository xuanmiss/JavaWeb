package service.stock

import dao.IOrderDBAccessor
import entity.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by ymcvalu on 2017/5/27.
 */

@Service
class ShipmentsSvc:IShipmentsSvc{
    @Autowired
    lateinit private var orderAcc:IOrderDBAccessor
    override fun getUndoOrder(pageNo:Int): List<Array<Any>> {
        var list=orderAcc.undoneOrders(pageNo,12)
        var ret= mutableListOf<Array<Any>>()
        list.forEach{
            var o=it[0] as Order
            var lev=it[1] as Int?
            if(lev==null || o.quantity>lev)
                ret.add(arrayOf(o,false))
            else
                ret.add(arrayOf(o,true))
        }
        return ret
    }
}
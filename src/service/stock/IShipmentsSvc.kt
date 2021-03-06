package service.stock

import entity.Shipment
import entity.Stock
import util.PageBean


/**
 * Created by ymcvalu on 2017/5/27.
 */
interface IShipmentsSvc{
    fun getUndoOrder(pageNo:Int): PageBean<Array<Any>>
    fun getBatchesByModelWithQuantityLimit(order_no:String):List<Stock>
    fun handleOut(orderNo:String,stockId:Int):Boolean
    fun getListByPage(pageNo:Int):PageBean<Shipment>
}

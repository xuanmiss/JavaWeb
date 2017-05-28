package service.stock

import entity.Stock
import util.PageBean


/**
 * Created by ymcvalu on 2017/5/27.
 */
interface IShipmentsSvc{
    fun getUndoOrder(pageNo:Int): PageBean<Array<Any>>
    fun getBatchesByModelWithQuantityLimit(order_no:String):List<Stock>
}

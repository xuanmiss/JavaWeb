package service.stock

import util.PageBean


/**
 * Created by ymcvalu on 2017/5/27.
 */
interface IShipmentsSvc{
    fun getUndoOrder(pageNo:Int): PageBean<Array<Any>>

}

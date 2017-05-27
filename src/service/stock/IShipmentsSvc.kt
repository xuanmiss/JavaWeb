package service.stock

import org.omg.CORBA.Object

/**
 * Created by ymcvalu on 2017/5/27.
 */
interface IShipmentsSvc{
    fun getUndoOrder(pageNo:Int):List<Array<Any>>

}

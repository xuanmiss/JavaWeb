package service.order

import com.sun.org.apache.xpath.internal.operations.Bool
import entity.Order
import util.PageBean

/**
 * Created by ymcvalu on 2017/5/20.
 */
interface IOrderHandler{
    fun getOrdersByPage(pageNo:Int):PageBean<Order>
    fun getOrdersByPage(state:Int,pageNo:Int):PageBean<Order>
    fun getOrdersByPage(clerk:Int,state:Int,pageNo:Int):PageBean<Order>
    fun getOrderByPage(clerk:Int,pageNo:Int):PageBean<Order>
    fun hasOrderByClerk(clerk:Int):Boolean
    fun hasOrderByClient(client:Int):Boolean
}
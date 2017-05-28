package service.order

import com.sun.org.apache.xpath.internal.operations.Bool
import entity.Arrear
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
    fun fillOrder(order:Order,clerk:Int):Order
    fun commitOrder(order:Order)
    fun commitOrder(order:Order,arrear:Arrear)
    fun hasOrder(orderNo:String):Boolean
    fun getOrdersByClerkAndClientAndStatus(clerk:Int,client:Int,status:Int,pageNo:Int):PageBean<Order>
    fun getOrdersByClerkAndClient(clerk:Int,client:Int,pageNo:Int):PageBean<Order>
    fun getOrdersByClientAndStatus(client:Int,status:Int,pageNo:Int):PageBean<Order>
    fun getOrdersByClient(client:Int,pageNo:Int):PageBean<Order>
}
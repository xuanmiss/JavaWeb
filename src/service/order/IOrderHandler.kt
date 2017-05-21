package service.order

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
}
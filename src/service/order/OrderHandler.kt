package service.order

import dao.OrderDBAccessor
import entity.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import util.PageBean

/**
 * Created by ymcvalu on 2017/5/19.
 */
@Service("orderHandler")
class OrderHandler:IOrderHandler{
    @Autowired
    lateinit var orderAcc:OrderDBAccessor

    override fun getOrdersByPage(pageNo:Int):PageBean<Order>{
        var pb=PageBean<Order> ()
        pb.curPage=pageNo
        pb.maxRowCount=orderAcc.getCount(Order::class.java)
        pb.data=orderAcc.getListByPage(Order::class.java,pageNo,pb.curPage)
        return pb
    }

    override fun getOrdersByPage(state: Int, pageNo: Int):PageBean<Order> {
        var pb=PageBean<Order>()
        pb.curPage=pageNo
        pb.maxRowCount=orderAcc.getCountOfOrder(state)
        pb.data=orderAcc.getListByPage(state,pageNo,pb.maxRowCount)
        return pb
    }



    override fun getOrdersByPage(clerk: Int, state: Int, pageNo: Int):PageBean<Order> {
        var pb=PageBean<Order>()
        pb.curPage=pageNo
        pb.maxRowCount=orderAcc.getCountOfOrder(clerk,state)
        pb.data=orderAcc.getListByPage(clerk,state,pageNo,pb.maxRowCount)
        return pb
    }

    override fun getOrderByPage(clerk: Int, pageNo: Int): PageBean<Order> {
        var pb=PageBean<Order>()
        pb.curPage=pageNo
        pb.maxRowCount=orderAcc.getCountOfClerkOrder(clerk)
        pb.data=orderAcc.getClerkOrders(clerk,pageNo,pb.maxRowCount)
        return pb
    }

    override fun hasOrderByClerk(clerk: Int): Boolean {
        return orderAcc.hasOrderByClerk(clerk)
    }

    override fun hasOrderByClient(client: Int): Boolean {
        return orderAcc.hasOrderByClient(client)
    }
}
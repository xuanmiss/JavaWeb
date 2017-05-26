package service.order

import dao.IBaseDBAccessor
import dao.OrderDBAccessor
import entity.Clerk
import entity.Client
import entity.Model
import entity.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import service.brand.ModelHandleSvc
import service.clerk.ClerkHandleSvc
import util.PageBean
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

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
    @Autowired
    lateinit var baseDAO: IBaseDBAccessor<Any>

    override fun fillOrder(order: Order, clerk: Int):Order {
        order.clerk=baseDAO.getObj(Clerk::class.java,clerk) as Clerk
        order.model=baseDAO.getObj(Model::class.java,order.model.id) as Model
        order.receiver=baseDAO.getObj(Client::class.java,order.receiver.id) as Client
        order.date= Date()
        order.price=order.quantity*order.model.sale_price
        var order_no="10"+SimpleDateFormat("yyMMdd").format(order.date)
        var str=System.currentTimeMillis().toString().substring(8)
        order_no+=str
        order.order_no=order_no
        return order
    }
}
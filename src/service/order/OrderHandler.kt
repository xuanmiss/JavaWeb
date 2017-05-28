package service.order

import dao.IBaseDBAccessor
import dao.OrderDBAccessor
import entity.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import util.PageBean
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

    override fun hasOrder(orderNo: String):Boolean {
        return orderAcc.hasOrder(orderNo)
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

    override fun commitOrder(order: Order) {
        order.status=1
        baseDAO.insert(order)
        with(AccountFlow()){
            date=Date()
            clerk=order.clerk
            order_no=order.id
            amount=order.price
            type=2
            description="卖出收入"
            baseDAO.insert(this)
        }
    }


    override fun commitOrder(order: Order, arrear: Arrear) {
        order.status=1
        baseDAO.insert(order)
        baseDAO.insert(arrear)

        with(AccountFlow()){
            date=Date()
            clerk=order.clerk
            order_no=order.id
            amount=order.price
            type=2
            description="卖出收入"
            baseDAO.insert(this)
        }

        with(AccountFlow()){
            date=Date()
            clerk=order.clerk
            order_no=arrear.id
            amount=-order.price
            type=4
            description="白条借出"
            baseDAO.insert(this)
        }
    }

    override fun getOrdersByClerkAndClientAndStatus(clerk: Int, client: Int, status: Int, pageNo: Int): PageBean<Order> {
        var pb=PageBean<Order>()
        pb.curPage=pageNo
        pb.maxRowCount=orderAcc.getCountByClerkAndClientAndState(clerk,client,status);
        pb.data=orderAcc.getListByPage(clerk,client,status,pageNo,pb.rowsPerPage)
        return pb
    }

    override fun getOrdersByClerkAndClient(clerk: Int, client: Int, pageNo: Int): PageBean<Order> {
        var pb=PageBean<Order>()
        pb.curPage=pageNo
        pb.maxRowCount=orderAcc.getCountByClerkAndClient(clerk,client)
        pb.data=orderAcc.getLIstByClerkAndClient(clerk,client,pageNo,pb.rowsPerPage)
        return pb
    }

    override fun getOrdersByClientAndStatus(client: Int, status: Int, pageNo: Int): PageBean<Order> {
        var pb=PageBean<Order>()
        pb.curPage=pageNo
        pb.maxRowCount=orderAcc.getCountByClinetANdState(client,status)
        pb.data=orderAcc.getListByClient(client,status,pageNo,pb.rowsPerPage)
        return pb
    }

    override fun getOrdersByClient(client: Int, pageNo: Int): PageBean<Order> {
        var pb=PageBean<Order>()
        pb.curPage=pageNo
        pb.maxRowCount=orderAcc.getCountByClient(client)
        pb.data=orderAcc.getListByClient(client,pageNo,pb.rowsPerPage)
        return pb
    }
}
package service.stock

import com.opensymphony.xwork2.ActionContext
import dao.IBaseDBAccessor
import dao.IOrderDBAccessor
import dao.IShipmentDBAccessor
import dao.IStockDBAccessor
import entity.Clerk
import entity.Order
import entity.Shipment
import entity.Stock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import util.PageBean

/**
 * Created by ymcvalu on 2017/5/27.
 */

@Service
class ShipmentsSvc:IShipmentsSvc{
    @Autowired
    lateinit private var orderAcc:IOrderDBAccessor
    override fun getUndoOrder(pageNo:Int):PageBean<Array<Any>> {
        var pb=PageBean<Array<Any>>()
        pb.curPage=pageNo
        pb.rowsPerPage=13
        pb.maxRowCount=orderAcc.getCountOfOrder(1)
        var list=orderAcc.undoneOrders(pageNo,pb.rowsPerPage)
        var ret= mutableListOf<Array<Any>>()
        list.forEach{
            var o=it[0] as Order
            var lev=it[1] as Int?
            if(lev==null || o.quantity>lev)
                ret.add(arrayOf(o,false))
            else
                ret.add(arrayOf(o,true))
        }
        pb.data=ret
        return pb
    }

    @Autowired
    private lateinit var stockAcc: IStockDBAccessor
    override fun getBatchesByModelWithQuantityLimit(orderNo:String):List<Stock> {
        var order=orderAcc.getOrder(orderNo)
        var model:Int=order.model.id
        var quantity=order.quantity
        return stockAcc.findStockByModelWithQuantityLimit(quantity,model)
    }
    @Autowired
    private lateinit var baseDao:IBaseDBAccessor<Any>
    override fun handleOut(orderNo: String, stockId: Int): Boolean {
        var order=orderAcc.getOrder(orderNo)
        var stock=stockAcc.getObj(Stock::class.java,stockId)
        var clerk=baseDao.getObj(Clerk::class.java,ActionContext.getContext().session["clerk"] as Int) as Clerk
        if(stock.count>=order.quantity){
            stock.count-=order.quantity
            order.status=2
            if(stock.count==0)
                stockAcc.delete(stock)
            var shipment =Shipment()
            shipment.batch=stock.batch
            shipment.clerk=clerk
            shipment.order_form=order
            baseDao.insert(shipment)
            return true
        }
        return false
     }

    @Autowired
    private lateinit var shipmentsDBAcc:IShipmentDBAccessor
    override fun getListByPage(pageNo: Int): PageBean<Shipment> {
        val pb = PageBean<Shipment>()
        pb.curPage = pageNo
        pb.maxRowCount = shipmentsDBAcc.getCount(Shipment::class.java)
        pb.data = shipmentsDBAcc.getListByPage(Shipment::class.java, pageNo, pb.rowsPerPage)
        return pb
    }
}
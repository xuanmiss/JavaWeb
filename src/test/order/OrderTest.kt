package test.order

import entity.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.stereotype.Component
import service.brand.BrandHandleSvc
import service.order.IOrderHandler
import service.stock.IShipmentsSvc

/**
 * Created by ymcvalu on 2017/5/20.
 */

fun main(args:Array<String>){
    val context= ClassPathXmlApplicationContext("/test/test.xml")
    val test=context.getBean("orderTest",OrderTest::class.java )
    test.test()

}

@Component("orderTest")
@Scope("prototype")
open class OrderTest{
    @Autowired
    lateinit var shipments:IShipmentsSvc
    open fun test(){
        var list=shipments.getUndoOrder(1)
        list.forEach {
            var o=it[0] as Order
            var flag=it[1] as Boolean?
            println("${o.order_no}:$flag")
        }
    }
}
package test.order

import controller.brand.BrandManageAction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.stereotype.Component
import service.brand.BrandHandleSvc
import service.order.IOrderHandler

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
    lateinit var orderSvc:IOrderHandler
    open fun test(){

    }
}
package test.ClerkBrand

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.stereotype.Component
import service.clerk.IClerkBrandHandleSvc
import service.order.IOrderHandler

/**
 * Created by ymcvalu on 2017/5/21.
 */

fun main(args:Array<String>){
    val context= ClassPathXmlApplicationContext("/test/test.xml")
    val test=context.getBean("cbTest",CBTest::class.java )
    test.test()
}

@Component("cbTest")
@Scope("prototype")
open class CBTest{
    @Autowired
    lateinit var cbSvc: IClerkBrandHandleSvc
    open fun test(){
        var cb=cbSvc.getClerk_Brand(6)
        println(cb?.clerk?.name+":"+cb?.brand?.name)
    }
}


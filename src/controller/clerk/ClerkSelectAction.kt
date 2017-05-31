package controller.brand

import com.opensymphony.xwork2.ActionSupport
import entity.Clerk
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Controller
import service.clerk.IClerkHandleSvc

/**
 * Created by ymcvalu on 2017/5/11.
 */
@Controller("selectClerk")
@Scope("prototype")
open class ClerkSelectAction:ActionSupport(){
    @Autowired
    private lateinit var clerkSvc: IClerkHandleSvc
    //open var pageBean:PageBean<Clerk>?=null
    //open var pageNo:Int=1
    open var listOfClerk:List<Clerk>?=null
    override fun execute(): String {
        listOfClerk=clerkSvc.getListClerkOfWork()
        return "list"
    }
}

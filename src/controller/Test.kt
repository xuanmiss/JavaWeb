package controller

import com.opensymphony.xwork2.Action
import com.opensymphony.xwork2.ActionSupport
import dao.IClerkDBAccessor
import entity.Clerk
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Controller
import javax.annotation.Resource

/**
 * Created by ymcvalu on 2017/5/4.
 */
@Controller("test")
@Scope("prototype")
class Test:ActionSupport(){
    var count:Int=0
    val msg
        get()="there are $count clerks"
    @Resource(name="clerkDBAcc")
    lateinit var clerkDBAcc:IClerkDBAccessor
    override  fun execute():String{
        var session=clerkDBAcc.getSession()
        session.transaction.begin()
        count=clerkDBAcc.getCount(Clerk::class.java)
        session.transaction.commit()
        return Action.SUCCESS
    }
}
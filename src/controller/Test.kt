package controller

import com.opensymphony.xwork2.Action
import com.opensymphony.xwork2.ActionSupport
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Controller

/**
 * Created by ymcvalu on 2017/5/4.
 */
@Controller("test")
@Scope("prototype")
class Test:ActionSupport(){
    val msg="a test page"
    override  fun execute():String{
        return Action.SUCCESS
    }
}
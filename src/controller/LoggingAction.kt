package controller

import com.opensymphony.xwork2.Action
import com.opensymphony.xwork2.ActionContext
import com.opensymphony.xwork2.ActionSupport
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Controller
import service.ILoggingHandler

/**
 * Created by ymcvalu on 2017/5/7.
 */
@Controller("logging")
@Scope("prototype")
class LoggingAction :ActionSupport(){
    var username:String?=null
    var password:String?=null
    @Autowired
    lateinit var loggingHandler:ILoggingHandler
    override fun execute():String{
        val role=loggingHandler.handler(username,password)
        if(role==null)
            return Action.LOGIN
        val session=ActionContext.getContext().session
        //保存用户名
        session["username"]=username
        //保存用户权限
        session["authority"]=role.authority
        //保存用户身份ID
        session["clerk"]=role.id
        return Action.SUCCESS
    }
}
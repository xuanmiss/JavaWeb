package controller.authority

import com.opensymphony.xwork2.Action
import com.opensymphony.xwork2.ActionContext
import com.opensymphony.xwork2.ActionSupport
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Controller
import service.login.ILoginHandler

/**
 * Created by ymcvalu on 2017/5/7.
 */
@Controller("login")
@Scope("prototype")
open class LoginAction : ActionSupport(){
    open var username:String?=null
    open var password:String?=null
    open var msg:String?=null
    @Autowired
    open lateinit var loginHandler: ILoginHandler
    override fun execute():String{
        val role= loginHandler.handler(username,password)
        if(role==null){
            msg="账户或密码错误，请检查输入"
            return Action.LOGIN
        }

        val session= ActionContext.getContext().session
        //保存用户名
        session["username"]=username
        //保存用户权限
        session["authority"]=role.authority
        //保存用户身份ID
        session["clerk"]=role.id
        return Action.SUCCESS
    }
}

package controller.authority

import com.opensymphony.xwork2.Action
import com.opensymphony.xwork2.ActionContext
import com.opensymphony.xwork2.ActionSupport
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Controller

/**
 * Created by ymcvalu on 2017/5/9.
 */
@Controller("logout")
@Scope("prototype")
class LogoutAction:ActionSupport(){
    override fun execute(): String {
        val session=ActionContext.getContext().session;
        session.remove("username")
        session.remove("authority")
        session.remove("clerk")
        return SUCCESS
    }
}
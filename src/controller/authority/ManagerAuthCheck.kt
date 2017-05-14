package controller.authority

import com.opensymphony.xwork2.ActionContext
import com.opensymphony.xwork2.ActionInvocation
import com.opensymphony.xwork2.interceptor.AbstractInterceptor
import org.springframework.stereotype.Controller

/**
 * Created by ymcvalu on 2017/5/14.
 */
@Controller("managerCheck")
open class ManagerAuthCheck:AbstractInterceptor(){
    override fun intercept(actionInvocation: ActionInvocation): String {
        val session=ActionContext.getContext().session
        return if(session["authority"]==3) actionInvocation.invoke() else "noAuthority"
    }
}
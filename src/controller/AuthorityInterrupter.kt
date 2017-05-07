package controller

import com.opensymphony.xwork2.ActionContext
import com.opensymphony.xwork2.ActionInvocation
import com.opensymphony.xwork2.ActionSupport
import com.opensymphony.xwork2.interceptor.AbstractInterceptor
import com.opensymphony.xwork2.interceptor.Interceptor
import org.omg.PortableInterceptor.SUCCESSFUL
import org.springframework.stereotype.Controller

/**
 * Created by ymcvalu on 2017/5/7.
 */
@Controller("authorityCheck")
open class AuthorityInterrupter:AbstractInterceptor(){
    override fun intercept(actionInvocation: ActionInvocation ): String {
        //如果不是访问登陆验证的action
         if(actionInvocation.action::class.simpleName!="LoggingAction"){
             val session=ActionContext.getContext().session
             //如果session没有用户名则未登录，返回登陆页面，否则放行
             return if(session["username"]==null) ActionSupport.LOGIN else actionInvocation.invoke()
        }
        //访问登陆验证action，放行
        return actionInvocation.invoke()
    }


}
package controller

import com.opensymphony.xwork2.ActionContext
import com.opensymphony.xwork2.ActionInvocation
import com.opensymphony.xwork2.ActionSupport
import com.opensymphony.xwork2.interceptor.AbstractInterceptor

import org.springframework.stereotype.Controller

/**
 * Created by ymcvalu on 2017/5/7.
 */

@Controller("authorityCheck")
open class AuthorityInterrupter:AbstractInterceptor(){
    override fun intercept(actionInvocation: ActionInvocation ): String {
             val session=ActionContext.getContext().session
             //如果session没有用户名则未登录，返回登陆页面，否则放行
             return if(session["username"]==null) ActionSupport.LOGIN else actionInvocation.invoke()
    }
}
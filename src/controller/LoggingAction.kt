package controller

import com.opensymphony.xwork2.Action
import com.opensymphony.xwork2.ActionSupport

/**
 * Created by ymcvalu on 2017/5/7.
 */
class LoggingAction :ActionSupport(){
    var username:String?=null
    var password:String?=null
    override fun execute():String{


        return Action.SUCCESS
    }
}
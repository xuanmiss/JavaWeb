package controller.client

import com.opensymphony.xwork2.ActionSupport
import entity.Client
import org.springframework.beans.factory.annotation .Autowired
import org.springframework.context.annotation .Scope
import org.springframework.stereotype.Controller
import service.client.IClientHandleSvc
import util.PageBean
/**
 * Created by miss on 2017/5/16.
 */

@Controller("selectClient")
@Scope("request")
open class ClientSelectAction:ActionSupport(){
    @Autowired
    private lateinit var clientSvc: IClientHandleSvc
    open var pageBean:PageBean<Client>?=null
    open var pageNo:Int=1
    override fun execute(): String {
        pageBean=clientSvc.getListByPage(pageNo)
        return SUCCESS
    }
}
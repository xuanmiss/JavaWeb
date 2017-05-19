package controller.brand

import com.opensymphony.xwork2.ActionContext
import com.opensymphony.xwork2.ActionSupport
import dao.ClerkDBAccessor
import entity.Brand
import entity.Clerk
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Controller
import service.brand.IBrandHandleSvc
import util.PageBean

/**
 * Created by ymcvalu on 2017/5/11.
 */
@Controller("selectBrand")
@Scope("request")
open class BrandSelectAction:ActionSupport(){
    @Autowired
    private lateinit var brandSvc: IBrandHandleSvc
    open var pageBean:PageBean<Brand>?=null
    open var pageNo:Int=1
    override fun execute(): String {
        pageBean=brandSvc.getListByPage(pageNo)
        return SUCCESS
    }
}

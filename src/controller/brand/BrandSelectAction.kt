package controller.brand

import com.opensymphony.xwork2.ActionSupport
import entity.Brand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import service.brand.IBrandHandleSvc
import util.PageBean

/**
 * Created by ymcvalu on 2017/5/11.
 */
@Controller("selectBrand")
open class BrandSelectAction:ActionSupport(){
    @Autowired
    open lateinit var brandSvc: IBrandHandleSvc
    open var pageBean:PageBean<Brand>?=null
    open var pageNo:Int=1
    override fun execute(): String {
        pageBean=brandSvc.getListByPage(pageNo)
        return SUCCESS
    }
}

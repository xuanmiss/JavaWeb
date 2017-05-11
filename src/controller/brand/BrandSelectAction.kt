package controller.brand

import com.opensymphony.xwork2.ActionSupport
import entity.Brand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import service.brand.IHandleBrandSvc
import util.PageBean

/**
 * Created by ymcvalu on 2017/5/11.
 */
@Controller("selectBrand")
class BrandSelectAction:ActionSupport(){
    @Autowired
    lateinit private var brandSvc:IHandleBrandSvc
    var pageBean:PageBean<Brand>?=null
    var pageNo:Int=1
    override fun execute(): String {
        pageBean=brandSvc.getListByPage(pageNo)
        return SUCCESS
    }
}

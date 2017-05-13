package controller.brand

import com.opensymphony.xwork2.ActionSupport
import entity.Model
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import service.brand.IBrandHandleSvc
import service.brand.IModelHandleSvc
import util.PageBean

/**
 * Created by ymcvalu on 2017/5/13.
 */
@Controller("selectModel")
open class ModelSelectAction:ActionSupport(){

    open var id=0
    open lateinit var pageBean:PageBean<Model>
    @Autowired
    private lateinit var modelSvc:IModelHandleSvc
    @Autowired
    private lateinit var brandSvc:IBrandHandleSvc
    open lateinit var brand:String
    open  var pageNo=1

    override fun execute(): String {
        pageBean=modelSvc.getListByPage(id,pageNo)
        brand=brandSvc.getBrandName(id)
        return SUCCESS
    }

}
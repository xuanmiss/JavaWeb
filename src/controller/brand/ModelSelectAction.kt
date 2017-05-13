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
class ModelSelectAction:ActionSupport(){

    var id=0
    lateinit var pageBean:PageBean<Model>
    @Autowired
    lateinit var modelSvc:IModelHandleSvc
    @Autowired
    lateinit var brandSvc:IBrandHandleSvc
    lateinit var brand:String
    var pageNo=1

    override fun execute(): String {
        pageBean=modelSvc.getListByPage(id,pageNo)
        brand=brandSvc.getBrandName(id)
        return SUCCESS
    }

}
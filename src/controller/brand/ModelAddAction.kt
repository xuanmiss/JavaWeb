package controller.brand

import com.opensymphony.xwork2.ActionSupport
import entity.Brand
import entity.Model
import org.apache.struts2.components.File
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import service.brand.BrandHandleSvc
import util.StringUtil

/**
 * Created by ymcvalu on 2017/5/11.
 */

@Controller("addModel")
class ModelAddAction: ActionSupport(){
    lateinit var model: Model
    lateinit var image:File
    lateinit var imageContentType:String
    lateinit var imageFileName:String
    lateinit var savePath:String
    lateinit var brand:Brand
    @Autowired
    lateinit var brandSvc: BrandHandleSvc
    fun request():String{
        brand=brandSvc.findById(brand.id)
        return SUCCESS
    }
    fun handle():String{


        return SUCCESS
    }



    override fun validate():Unit{
        model.model=StringUtil.ignoreSpace(model.model)
        if(StringUtil.isEmptyString(model.model))
            addFieldError("model","请输入瓷砖型号!")


    }

}
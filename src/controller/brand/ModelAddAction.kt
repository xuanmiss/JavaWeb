package controller.brand

import com.opensymphony.xwork2.ActionSupport
import entity.Brand
import entity.Model
import org.apache.struts2.components.File
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import service.brand.BrandHandleSvc

/**
 * Created by ymcvalu on 2017/5/11.
 */

@Controller("addModel")
open class ModelAddAction: ActionSupport(){
    open lateinit var model: Model
    open lateinit var image:File
    open lateinit var imageContentType:String
    open lateinit var imageFileName:String
    open lateinit var savePath:String
    open lateinit var brand:Brand
    @Autowired
    private lateinit var brandSvc: BrandHandleSvc
    open fun request():String{
        //brand=brandSvc.findById(brand.id)
        return "request"
    }
    open fun handle():String{


        return "handle"
    }



    override fun validate():Unit{
        /**
        model.model=model.model.trim()
        if(StringUtil.isEmptyString(model.model))
            addFieldError("model","请输入瓷砖型号!")
**/

    }

}
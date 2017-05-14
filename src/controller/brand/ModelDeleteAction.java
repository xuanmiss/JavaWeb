package controller.brand;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.brand.IModelHandleSvc;

/**
 * Created by ymcvalu on 2017/5/14.
 */

@Controller("deleteModel")
@Scope("prototype")
public class ModelDeleteAction extends ActionSupport {
    private int modelId;
    private int brandId;
    private int flag=0;
    @Autowired
    private IModelHandleSvc modelSvc;


    @Override
    public String execute(){
        if(!modelSvc.delect(modelId))
           flag=1;
        return SUCCESS;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }


    public IModelHandleSvc getModelSvc() {
        return modelSvc;
    }

    public void setModelSvc(IModelHandleSvc modelSvc) {
        this.modelSvc = modelSvc;
    }
}

package controller.brand;

import com.opensymphony.xwork2.ActionSupport;
import entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.brand.IBrandHandleSvc;

/**
 * Created by chenshihong on 2017/5/11.
 */
@Controller("manageBrand")
@Scope("request")
public class BrandManageAction extends ActionSupport{
    private Brand brand;
    private int brandId;
    //用于删除品牌时作为标记，默认为0，不可删除时置为 1
    private int isExit=0;
    @Autowired
    private IBrandHandleSvc brandSvc;
    public String manage(){
        brand = brandSvc.findById(brandId);
        return SUCCESS;
    }
    public  String delete(){

        if (brandSvc.deleteBrand(brandId)){
            isExit = 0;
            return "deletesuccess";
        }
        else {
            isExit = 1;
            brand = brandSvc.findById(brandId);
            return "deletefalse";
        }
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getIsExit() {
        return isExit;
    }

    public void setIsExit(int isExit) {
        this.isExit = isExit;
    }
}

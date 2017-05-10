package controller.brand;

import com.opensymphony.xwork2.ActionSupport;
import entity.Brand;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.brand.IHandleBrandSvc;
import util.DiskUtil;
import util.StringUtil;
import java.io.File;
import java.util.Date;

/**
 * Created by ymcvalu on 2017/5/9.
 */
@Controller("addBrand")
@Scope("prototype")
public class BrandAddAction extends ActionSupport{
    private File logo;
    private String logoContentType;
    private String logoFileName;
    private Brand brand;
    private String savePath;
    private String msg=null;


    @Autowired
    private IHandleBrandSvc brandSvc;
    @Override
    public String execute()throws Exception{
        if(!isValidate())
            return LOGIN;
        brand.setDescription(StringUtil.ignoreSpace(brand.getDescription()));
        brand.setDate(new Date());
        brand.setStatus(0);
        String fileName="\\"+brand.getName()+".png";
        brand.setLogo(savePath+fileName);
        DiskUtil.write(getSavePath()+fileName,logo);
        brandSvc.saveBrand(brand);
        msg="success";
        return SUCCESS;
    }

    private boolean isValidate(){
        brand.setName(StringUtil.ignoreSpace(brand.getName()));
        if(StringUtil.isEmptyString(brand.getName())){
            msg="请输入品牌名!";
            return false;
        }

        brand.setSupplier(StringUtil.ignoreSpace(brand.getSupplier()));
        if(StringUtil.isEmptyString(brand.getSupplier())){
            msg="请输入供应商!";
            return false;
        }
        brand.setDescription(StringUtil.ignoreSpace(brand.getDescription()));
        if(StringUtil.isEmptyString(brand.getDescription())){
            msg="请输入品牌介绍!";
        }
        if(logo==null){
            msg="请上传品牌logo";
            return false;
        }

        if(!logoContentType.toLowerCase().startsWith("image")){
            msg="文件格式不正确!";
            return false;
        }
        if(brandSvc.isExist(brand.getName())){
            msg="该品牌已存在!";
            return false;
        }

        return true;
    }


    public File getLogo() {
        return logo;
    }

    public void setLogo(File logo) {
        this.logo = logo;
    }

    public String getLogoContentType() {
        return logoContentType;
    }

    public void setLogoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
    }

    public String getLogoFileName() {
        return logoFileName;
    }

    public void setLogoFileName(String logoFileName) {
        this.logoFileName = logoFileName;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getSavePath() {
        return ServletActionContext.getServletContext().getRealPath(savePath);
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
    public String getMsg() {
        return msg;
    }
    public IHandleBrandSvc getBrandSvc() {
        return brandSvc;
    }

    public void setBrandSvc(IHandleBrandSvc brandSvc) {
        this.brandSvc = brandSvc;
    }

}



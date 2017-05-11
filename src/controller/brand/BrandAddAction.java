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


    @Autowired
    private IHandleBrandSvc brandSvc;
    @Override
    public String execute()throws Exception{
        brand.setDate(new Date());
        brand.setStatus(0);
        //保存相对路径
        brand.setLogo(savePath+"\\"+brand.getName()+".png");

        //保存图片，使用绝对路径
        DiskUtil.write(DiskUtil.getRealPath(brand.getLogo()),logo);
        //保存品牌信息
        brandSvc.saveBrand(brand);

        return SUCCESS;
    }

    @Override
    public void validate(){

        //忽略开始空字符
        brand.setName(StringUtil.ignoreSpace(brand.getName()));
        //判空
        if(StringUtil.isEmptyString(brand.getName()))
            addFieldError("name","品牌名不能为空!");

        //品牌名不能重复
        else  if(brandSvc.isExist(brand.getName()))
            addFieldError("name","该品牌已存在!");

        brand.setSupplier(StringUtil.ignoreSpace(brand.getSupplier()));
        if(StringUtil.isEmptyString(brand.getSupplier()))
            addFieldError("supplier","供应商不能为空!");

        brand.setDescription(StringUtil.ignoreSpace(brand.getDescription()));
        if(StringUtil.isEmptyString(brand.getDescription()))
            addFieldError("description","品牌描述不能为空!");

        if(logo==null)
            addFieldError("logo","请上传品牌logo!");
        else if(!logoContentType.toLowerCase().startsWith("image"))
            addFieldError("logo","不合法的文件格式!");
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
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public IHandleBrandSvc getBrandSvc() {
        return brandSvc;
    }

    public void setBrandSvc(IHandleBrandSvc brandSvc) {
        this.brandSvc = brandSvc;
    }

}



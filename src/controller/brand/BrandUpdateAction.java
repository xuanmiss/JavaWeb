package controller.brand;

import com.opensymphony.xwork2.ActionSupport;
import entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.brand.IBrandHandleSvc;
import util.DiskUtil;
import util.StringUtil;

import java.awt.*;
import java.io.File;
import java.util.Date;

/**
 * Created by chenshihong on 2017/5/14.
 */
@Controller("updateBrand")
@Scope("request")
public class BrandUpdateAction extends ActionSupport{
    private File logo;
    private String logoContentType;
    private String logoFileName;
    private Brand brand;
    private int brandId=0;
    private String savePath;

    @Autowired
    private IBrandHandleSvc brandSvc;

    public String handle()throws Exception{;
        //保存相对路径
        if(logo!=null) {
            brand.setLogo(savePath + "\\" + brand.getName() + ".png");
            //保存图片，使用绝对路径
            DiskUtil.write(DiskUtil.getRealPath(brand.getLogo()), logo);
        }
        //保存品牌信息

        brandSvc.updateBrand(brand);

        return "handle";
    }
    public String request (){
        brand = brandSvc.findById(brandId);
        return  "request";
    }
    @Override
    public void validate(){
        if(brandId!=0)
            return;
        //忽略开始空字符
        Brand preBrand = brandSvc.findById(brand.getId());
        brand.setName(brand.getName().trim());
        //判空
        if(StringUtil.isEmptyString(brand.getName()))
            addFieldError("name","品牌名不能为空!");

            //品牌名不能重复
        else  if((brand.getName().equals(preBrand.getName())==false) && brandSvc.isExist(brand.getName()))
            addFieldError("name","该品牌已存在!");

        brand.setSupplier(brand.getSupplier().trim());
        if(StringUtil.isEmptyString(brand.getSupplier()))
            addFieldError("supplier","供应商不能为空!");

        brand.setDescription(brand.getDescription().trim());
        if(StringUtil.isEmptyString(brand.getDescription()))
            addFieldError("description","品牌描述不能为空!");
         if(logo!=null && !logoContentType.toLowerCase().startsWith("image"))
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

    public IBrandHandleSvc getBrandSvc() {
        return brandSvc;
    }

    public void setBrandSvc(IBrandHandleSvc brandSvc) {
        this.brandSvc = brandSvc;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
}

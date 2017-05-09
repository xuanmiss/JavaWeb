package controller.brand;

import com.opensymphony.xwork2.ActionSupport;
import entity.Brand;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.brand.IHandleBrandSvc;
import util.StringUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
        if(!isValidate()) {
            msg="请输入完整信息!";
            return LOGIN;
        }
        if(!logoContentType.toLowerCase().startsWith("image")){
            msg="文件格式不正确!";
            return LOGIN;
        }
        if(brandSvc.isExist(brand.getName())){
            msg="该品牌已存在!";
            return LOGIN;
        }
        brand.setDate(new Date());
        brand.setStatus(0);
        String fileName=savePath+"\\"+brand.getName()+".png";
        brand.setLogo(fileName);
        FileOutputStream fos=new FileOutputStream(getSavePath()+"\\"+brand.getName()+".png");
        FileInputStream fis=new FileInputStream(logo);
        try{
            byte[]buffer=new byte[1024];
            int len=0;
            while((len=fis.read(buffer))>0)
                fos.write(buffer,0,len);
        }catch (Exception e){
            throw e;
        }finally {
            fis.close();
            fos.close();
        }
        brandSvc.saveBrand(brand);
        msg="success";
        return SUCCESS;
    }

    private boolean isValidate(){
        if(StringUtil.isEmptyString(brand.getName()))
            return false;
        if(StringUtil.isEmptyString(brand.getSupplier()))
            return false;
        if(logo==null)
            return false;
        else
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



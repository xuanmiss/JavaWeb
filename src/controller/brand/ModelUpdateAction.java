package controller.brand;

import com.opensymphony.xwork2.ActionSupport;
import entity.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.brand.IBrandHandleSvc;
import service.brand.IModelHandleSvc;
import util.DiskUtil;
import util.StringUtil;

import java.io.File;

/**
 * Created by chenshihong on 2017/5/14.
 */
@Controller("updateModel")
@Scope("prototype")
public class ModelUpdateAction extends ActionSupport{
    private Model model;
    private File image;
    private String imageContentType;
    private String imageFileName;
    private String savePath;
    private int brandId=0;
    private int modelId;
    private String brandName;
    @Autowired
    private IBrandHandleSvc brandSvc;
    @Autowired
    private IModelHandleSvc modelSvc;

    public String request(){
        model = modelSvc.getModelById(brandId,modelId);
        return "request";
    }

    public String handle()throws Exception{;
        //保存相对路径
        if(image!=null) {
            String fileName=savePath+"\\"+model.getModel()+".png";
            model.setImage(fileName);
            //保存图片，使用绝对路径
            DiskUtil.write(DiskUtil.getRealPath(fileName),image);
        }
        //保存品牌信息
        brandId=model.getBrand().getId();
        modelSvc.updateModel(model);

        return "handle";
    }
    @Override
    public void validate(){
        if(modelId!=0)
            return ;
        brandId=model.getBrand().getId();
        Model preModel = modelSvc.getModelById(brandId,model.getId());
        if(model.getIn_price()==0)
            addFieldError("in_price","请输入有效进价!");

        if(model.getSale_price()==0)
            addFieldError("sale_price","请输入有效单价!");

        if(StringUtil.isEmptyString(model.getModel()))
            addFieldError("model","型号不能为空!");
        else if((model.getModel().equals(preModel.getModel())==false) &&  modelSvc.isExist(model.getModel(),brandId))
            addFieldError("model","该型号已经存在!");

        if(StringUtil.isEmptyString(model.getColor()))
            addFieldError("color","花色不能为空!");

        if(StringUtil.isEmptyString(model.getFormat()))
            addFieldError("format","规格不能为空!");

        if(image!=null && !imageContentType.toLowerCase().startsWith("image"))
            addFieldError("image","请上传图片格式资源!");

    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}

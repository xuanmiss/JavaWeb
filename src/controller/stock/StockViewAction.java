package controller.stock;

import com.opensymphony.xwork2.ActionSupport;
import entity.Batch;
import entity.Brand;
import entity.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.batch.IBatchHandleService;
import service.brand.IBrandHandleSvc;
import service.brand.IModelHandleSvc;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */
@Controller("stockView")
@Scope("prototype")
public class StockViewAction extends ActionSupport{

    @Autowired
    private IBrandHandleSvc brandSvc;
    @Autowired
    private IModelHandleSvc modelSvc;
    @Autowired
    private IBatchHandleService batchSvc;

    private List<Brand> brandList;
    private List<Integer> modelList;
    private List<Batch> batchList;

    private int pageNo = 1;
    private int brandId;
    private int modelId;
    private int batchId;
    private int status = 0;

    @Override
    public String execute(){
        if(status == 0){
            brandId = 1;
            brandList = brandSvc.getAll();
            return "input";
        }

        check();
        loadStock();
        return SUCCESS;
    }

    public String loadBrand(){
        brandList = brandSvc.getListByPage(pageNo).getData();
        return SUCCESS;
    }

    public String loadModel(){
        List<Model> list=modelSvc.getModelByBrand(brandId);
        modelList=new LinkedList<>();
        list.forEach((it)->{
            modelList.add(it.getId());
        });
        System.out.println("fetch size:"+modelList.size());
        return SUCCESS;
    }

    public String loadBatch(){
        batchList = batchSvc.getBatchByModel(modelId);
        return SUCCESS;
    }

    public void check(){

    }

    public String loadStock(){
        return SUCCESS;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Integer> getModelList() {
        return modelList;
    }

    public void setModelList(List<Integer> modelList) {
        this.modelList = modelList;
    }

    public List<Batch> getBatchList() {
        return batchList;
    }

    public void setBatchList(List<Batch> batchList) {
        this.batchList = batchList;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
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

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

}

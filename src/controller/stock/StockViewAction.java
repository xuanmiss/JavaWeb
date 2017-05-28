package controller.stock;

import com.opensymphony.xwork2.ActionSupport;
import entity.Batch;
import entity.Brand;
import entity.Model;
import entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.batch.IBatchHandleService;
import service.brand.IBrandHandleSvc;
import service.brand.IModelHandleSvc;
import service.stock.IStockSvc;

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
    @Autowired
    private IStockSvc stockSvc;

    private List<Brand> brandList;
    private List<Model> modelList;
    private List<Batch> batchList;
    private List<Stock> stockList;

    private int pageNo = 1;
    private int brandId;
    private int modelId;
    private int batchId;
    private int status = 0;

    @Override
    public String execute(){
        if(status == 0){
            brandList = brandSvc.getAll();
            modelList = modelSvc.getModelByBrand(brandList.get(0).getId());
            return "input";
        }

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
            Model m = new Model();
            m.setId(it.getId());
            m.setModel(it.getModel());
            modelList.add(m);
        });
        System.out.println("fetch size:"+modelList.size());
        return SUCCESS;
    }

    public String loadBatch(){
        List<Batch> list = batchSvc.getBatchByModel(modelId);
        batchList=new LinkedList<>();
        list.forEach((it)->{
            Batch b = new Batch();
            b.setId(it.getId());
            b.setBatch_no(it.getBatch_no());
            batchList.add(b);
        });
        System.out.println("fetch size:"+batchList.size());
        return SUCCESS;
    }

    public void check(){

    }

    public String loadStock(){
        Stock stock = stockSvc.findByBatch(batchId);
        Stock s = new Stock();
        s.setCount(stock.getCount());
        stockList =new LinkedList<>();
        stockList.add(s);
        System.out.println("所剩库存数：:"+s.getCount());
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


    public List<Model> getModelList() {
        return modelList;
    }

    public void setModelList(List<Model> modelList) {
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

    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }
}

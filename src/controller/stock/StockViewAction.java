package controller.stock;

import com.opensymphony.xwork2.ActionSupport;
import entity.Batch;
import entity.Brand;
import entity.Model;
import org.springframework.beans.factory.annotation.Autowired;
import service.brand.IBrandHandleSvc;
import service.brand.IModelHandleSvc;
import util.PageBean;

/**
 * Created by Administrator on 2017/5/23.
 */
public class StockViewAction extends ActionSupport{

    @Autowired
    private IBrandHandleSvc brandSvc;

    @Autowired
    private IModelHandleSvc modelSvc;

    private PageBean<Brand> brandPageBean;
    private PageBean<Model> modelPageBean;
    private PageBean<Batch> batchPageBean;

    @Override
    public String execute(){
        return SUCCESS;
    }



}

package controller.stock;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.brand.IBrandHandleSvc;
import service.brand.IModelHandleSvc;
import service.clerk.IClerkBrandHandleSvc;
import service.stock.IPurchaseSvc;
import util.PageBean;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by LCQ on 2017/5/23.
 */
@Controller("purchaseAction")
@Scope("prototype")
public class PurchaseAction extends ActionSupport {
    private List<Brand> brands;
    private List<Model> models;

    private Purchase_Order purchaseOrder;
    private String msg;

    @Autowired
    private IModelHandleSvc modelSvc;
    @Autowired
    private IBrandHandleSvc brandSvc;

    @Autowired
    private IClerkBrandHandleSvc cbSvc;

    public String requestAdd(){
        brands=new LinkedList<>();
        models=new LinkedList<>();
        int authority=(Integer) ActionContext.getContext().getSession().get("authority");

        if(authority==1){
            int clerkId=(Integer)ActionContext.getContext().getSession().get("authority");
            Brand b=cbSvc.getClerk_Brand(clerkId).getBrand();
            Brand _b=new Brand();
            _b.setId(b.getId());
            _b.setName(b.getName());
            brands.add(_b);
        } else{
            List<Brand> bs=brandSvc.getAll();
            bs.forEach(it->{
                Brand b=new Brand();
                b.setName(it.getName());
                b.setId(it.getId());
                brands.add(b);
            });
        }


        int modelId=brands.get(0).getId();
        List<Model> ms=modelSvc.getModelByBrand(modelId);
        ms.forEach(it->{
            Model m=new Model();
            m.setId(it.getId());
            m.setModel(it.getModel());
            models.add(m);
        });

        return SUCCESS;

    }

    @Autowired
    private IPurchaseSvc purchaseSvc;
    public String handleAdd(){
        boolean flag=purchaseSvc.addPurchaseOrder(purchaseOrder);
        if(flag)
         msg="进货申请成功!";
        else
            msg="申请失败，请重试!";
        return SUCCESS;
    }

    private PageBean<Purchase_Order> pageBean;
    private int pageNo=1;

    public String requestIn(){
        pageBean=purchaseSvc.getUndoPurchaseOrders(pageNo);
        pageBean.getData().forEach(it->{
            it.getModel().getModel();
            it.getClerk().getName();
        });
        return SUCCESS;
    }


    private Purchase purchase;

    public String handleIn(){
        purchaseSvc.inWarehouse(purchase);
        msg="入库成功";
        return SUCCESS;
    }


    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public Purchase_Order getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(Purchase_Order purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public PageBean<Purchase_Order> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<Purchase_Order> pageBean) {
        this.pageBean = pageBean;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public IModelHandleSvc getModelSvc() {
        return modelSvc;
    }

    public void setModelSvc(IModelHandleSvc modelSvc) {
        this.modelSvc = modelSvc;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}

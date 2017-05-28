package controller.stock;

import com.opensymphony.xwork2.ActionSupport;
import entity.Batch;
import entity.Clerk;
import entity.Order;
import entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.stock.PurchaseSvc;
import util.PageBean;
import java.util.List;

/**
 * Created by LCQ on 2017/5/23.
 */
@Controller("Purchase")
@Scope("prototype")
public class PurchaseAction extends ActionSupport {
    @Autowired
    private PurchaseSvc purchaseSvc;
    private Purchase purchase;
    private Batch batch;
    private Clerk clerk;

    private List<Batch> batchList = null;
    private List<Clerk> clerkList = null;
    private List<Order> orderList = null;
    private int deleteId;
    int pageNo;
    private PageBean<Purchase> pageBean = null;

    /**
     * 查询整表
     * */
    public String select(){
        pageNo = 1;
        pageBean = purchaseSvc.getAll(pageNo);
        for(int i=0 ; i<pageBean.getData().size(); i++){
            System.out.println(pageBean.getData().get(i));
        }
        return "list";
    }
    /**
     * 表单数据支持
     * */
    public String form(){
        batchList = purchaseSvc.getAllBatch();
        clerkList = purchaseSvc.getAllClerk();
        orderList = purchaseSvc.getAllOrder();
        return "option";
    }
    /**
     * 新增记录
     * */
    public String save(){
        Purchase p = new Purchase();
        /*batch = purchaseSvc.getBatchById(batch.getId());
        clerk = purchaseSvc.getClerkById(clerk.getId());
        order = purchaseSvc.getOrderById(order.getId());*/
        p.setBatch(batch);
        p.setClerk(clerk);

        purchaseSvc.savePurchase(p);
        return "add";
    }
    /**
     * 移除记录
     * */
    public String remove(){
        purchaseSvc.remove(deleteId);
        return "del";
    }


    /**
     * setter getter 方法
     * */
    public int getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(int deleteId) {
        this.deleteId = deleteId;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }



    public List<Batch> getBatchList() {
        return batchList;
    }

    public void setBatchList(List<Batch> batchList) {
        this.batchList = batchList;
    }

    public List<Clerk> getClerkList() {
        return clerkList;
    }

    public void setClerkList(List<Clerk> clerkList) {
        this.clerkList = clerkList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public PageBean<Purchase> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<Purchase> pageBean) {
        this.pageBean = pageBean;
    }

    public PurchaseSvc getPurchaseSvc() {
        return purchaseSvc;
    }

    public void setPurchaseSvc(PurchaseSvc purchaseSvc) {
        this.purchaseSvc = purchaseSvc;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}

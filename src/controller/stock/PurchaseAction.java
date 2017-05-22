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
 * Created by LCQ on 2017/5/21.
 */
@Controller("Purchase")
@Scope("prototype")
public class PurchaseAction extends ActionSupport {
    @Autowired
    private PurchaseSvc purchaseSvc;
    private Purchase purchase;
    private Batch batch;
    private Clerk clerk;
    private Order order;
    List<Batch> batchOption = null;
    List<Clerk> clerkOption = null;
    List<Order> orderOption = null;
    PageBean<Purchase> pageBean = null;
    int pageNo = 1;

    public String select(){
        pageBean = purchaseSvc.getListByPage(pageNo);
        return SUCCESS;
    }

    public String save(){
           purchase.setBatch(batch);
           purchase.setClerk(clerk);
           purchase.setOrder(order);
           purchaseSvc.savePurchase(purchase);
        return "show";
    }

    public String form(){
           batchOption = purchaseSvc.formBatchOption();
           clerkOption = purchaseSvc.formClerkOption();
           orderOption = purchaseSvc.formOrderOption();
           return "option";
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public List<Batch> getBatchOption() {
        return batchOption;
    }

    public void setBatchOption(List<Batch> batchOption) {
        this.batchOption = batchOption;
    }

    public List<Clerk> getClerkOption() {
        return clerkOption;
    }

    public void setClerkOption(List<Clerk> clerkOption) {
        this.clerkOption = clerkOption;
    }

    public List<Order> getOrderOption() {
        return orderOption;
    }

    public void setOrderOption(List<Order> orderOption) {
        this.orderOption = orderOption;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

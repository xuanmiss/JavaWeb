package controller.finance;

import com.opensymphony.xwork2.ActionSupport;
import entity.Account;
import entity.Purchase_Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import service.finance.IAccountHandleSvc;
import service.finance.IPurchaseOrderHandleSvc;
import util.PageBean;

/**
 * Created by chenshihong on 2017/5/21.
 */
@Controller("purchase")
@Scope("request")
public class PurchaseAction extends ActionSupport{
    @Autowired
    private  IAccountHandleSvc accountSvc;
    @Autowired
    private IPurchaseOrderHandleSvc purchaseOrderSvc;


    private PageBean<Purchase_Order> pageBean;
    private Account account;
    private int purchaseOrderId;
    private int pageNo = 1;

    @Override
    public String execute(){
        pageBean = purchaseOrderSvc.getListByPage(pageNo);
        account = accountSvc.getAccount();
        return SUCCESS;
    }

    public String purchaseOrder(){
        Purchase_Order order = purchaseOrderSvc.findById(purchaseOrderId);
       if(accountSvc.purchaseOrderAmount(order.getAmount())){
           accountSvc.insertAccountFlowByOrder(order);
           purchaseOrderSvc.setPurchaseOrderType(order);
           return SUCCESS;
       }
        else
            return "false";
    }
    public PageBean<Purchase_Order> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<Purchase_Order> pageBean) {
        this.pageBean = pageBean;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(int purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }
}

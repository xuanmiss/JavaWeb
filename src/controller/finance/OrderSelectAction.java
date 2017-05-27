package controller.finance;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Clerk;
import entity.Order;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.clerk.IClerkHandleSvc;
import service.finance.IOrderHandleSvc;
import util.PageBean;

import java.util.List;

/**
 * Created by chenshihong on 2017/5/19.
 */
@Controller("selectOrder")
@Scope("prototype")
public class OrderSelectAction extends ActionSupport{
    @Autowired
    private IOrderHandleSvc orderSvc;
    @Autowired
    private IClerkHandleSvc clerkSvc;

    private PageBean<Order> pageBean;
    private int pageNo = 1;
    private List<Clerk> clerks;
    private int clerkId;

    @Override
    public String execute(){
        pageBean = orderSvc.getPageListOrder(pageNo);
        clerks = clerkSvc.getListByPage(pageNo).getData();
       // clerkId = 50;
        return SUCCESS;
    }

    public String getClerkOrder(){
        //pageBean = orderSvc.getPageListOrder(2);
        clerkId= Integer.parseInt(ServletActionContext.getRequest().getParameter("clerkId"));
        pageBean = orderSvc.getPageListClerkOrder(clerkId,pageNo);
        clerks = clerkSvc.getListByPage(pageNo).getData();
       // clerkId = 100;
        return SUCCESS;
    }
    public PageBean<Order> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<Order> pageBean) {
        this.pageBean = pageBean;
    }

    public int getClerkId() {
        return clerkId;
    }

    public void setClerkId(int clerkId) {
        this.clerkId = clerkId;
    }

    public List<Clerk> getClerks() {
        return clerks;
    }

    public void setClerks(List<Clerk> clerks) {
        this.clerks = clerks;
    }



}

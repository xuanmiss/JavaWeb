package controller.finance;

import com.opensymphony.xwork2.ActionSupport;
import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.finance.IOrderHandleSvc;
import util.PageBean;

/**
 * Created by chenshihong on 2017/5/19.
 */
@Controller("selectOrder")
@Scope("prototype")
public class OrderSelectAction extends ActionSupport{
    @Autowired
    private IOrderHandleSvc orderSvc;
    private PageBean<Order> pageBean;
    private int pageNo = 1;
    @Override
    public String execute(){
        pageBean = orderSvc.getPageListOrder(pageNo);
        return SUCCESS;
    }

    public PageBean<Order> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<Order> pageBean) {
        this.pageBean = pageBean;
    }
}

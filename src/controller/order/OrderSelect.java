package controller.order;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Clerk;
import entity.Client;
import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.clerk.IClerkHandleSvc;
import service.client.IClientHandleSvc;
import service.order.IOrderHandler;
import util.PageBean;


/**
 * Created by ymcvalu on 2017/5/19.
 */
@Controller("selectByOrder")
@Scope("prototype")
public class OrderSelect extends ActionSupport {

    @Autowired
    private IOrderHandler orderHandler;
    @Autowired
    private IClerkHandleSvc clerkSvc;
    @Autowired
    private IClientHandleSvc clientSvc;

    private PageBean<Order> pageBean;
    private Integer pageNo = 1;
    private Integer clerk;
    private Integer client;
    private Integer status;
    private PageBean<Clerk> clerks;
    private Order order;
    private String duties;
    private String msg;
    private PageBean<Client> clients;

    public String requestForSelect(){

        int clerk= (int)ActionContext.getContext().getSession().get("clerk");

        duties = clerkSvc.findById(clerk).getDuties();

        if(duties.equals("经理")) {
            clerks = clerkSvc.getListByPage(pageNo);
            clients = clientSvc.getListByPage(pageNo);

            if(clerks == null) {
                msg = "无业务员信息，请添加业务员~~";
                return "error";
            }
            if(clients == null){
                msg = "无客户信息，请添加客户~~";
                return "error";
            }
            return "selectOrder";
        }
        if(duties.equals("业务员")){
            clients = clientSvc.getListByPage(pageNo);
            if(clients == null){
                msg = "无客户信息，请添加客户~~";
                return "error";
            }
            return "clerkSelectOrder";
        }
        msg = "非法登录";
        return "error";
    }

    public String selectBOrder(){
        if(clerk==0 && status==0 && client==0){
            msg = "你未添加查询条件，请添加查询条件~~";
            return "error";
        }else if(clerk==0 && status!=0 && client==0){
            pageBean = orderHandler.getOrdersByPage(status, pageNo);
            pageBean.getData().forEach((it)->{
                it.getClerk().getName();
            });
            pageBean.getData().forEach((it)->{
                it.getModel().getModel();
            });
            pageBean.getData().forEach((it)->{
                it.getReceiver().getName();
            });
        }else if(status==0 && clerk!=0 && client==0){
            pageBean = orderHandler.getOrderByPage(clerk, pageNo);
            pageBean.getData().forEach((it)->{
                it.getClerk().getName();
            });
            pageBean.getData().forEach((it)->{
                it.getModel().getModel();
            });
            pageBean.getData().forEach((it)->{
                it.getReceiver().getName();
            });
        }else if(status!=0 && clerk!=0 && client==0){
            pageBean = orderHandler.getOrdersByPage(clerk, status, pageNo);
            pageBean.getData().forEach((it)->{
                it.getClerk().getName();
            });
            pageBean.getData().forEach((it)->{
                it.getModel().getModel();
            });
            pageBean.getData().forEach((it)->{
                it.getReceiver().getName();
            });
        }else if(status==0 && clerk==0 && client!=0){
            pageBean = orderHandler.getOrdersByClient(client, pageNo);
            pageBean.getData().forEach((it)->{
                it.getClerk().getName();
            });
            pageBean.getData().forEach((it)->{
                it.getModel().getModel();
            });
            pageBean.getData().forEach((it)->{
                it.getReceiver().getName();
            });
        }else if(status!=0 && clerk==0 && client!=0){
            pageBean = orderHandler.getOrdersByClientAndStatus(client, status, pageNo);
            pageBean.getData().forEach((it)->{
                it.getClerk().getName();
            });
            pageBean.getData().forEach((it)->{
                it.getModel().getModel();
            });
            pageBean.getData().forEach((it)->{
                it.getReceiver().getName();
            });
        }else if(status==0 && clerk!=0 && client!=0){
            pageBean = orderHandler.getOrdersByClerkAndClient(clerk, client, pageNo);
            pageBean.getData().forEach((it)->{
                it.getClerk().getName();
            });
            pageBean.getData().forEach((it)->{
                it.getModel().getModel();
            });
            pageBean.getData().forEach((it)->{
                it.getReceiver().getName();
            });
        }else {
            pageBean = orderHandler.getOrdersByClerkAndClientAndStatus(clerk, client, status, pageNo);
            pageBean.getData().forEach((it)->{
                it.getClerk().getName();
            });
            pageBean.getData().forEach((it)->{
                it.getModel().getModel();
            });
            pageBean.getData().forEach((it)->{
                it.getReceiver().getName();
            });
        }
        return "showOrder";
    }

    public String clerkSelectBOrder(){
        if(client==0 && status==0){
            msg = "你未添加查询条件，请添加查询条件~~";
            return "error";
        }else if(client==0 && status!=0){
            pageBean = orderHandler.getOrdersByPage(status, pageNo);
            pageBean.getData().forEach((it)->{
                it.getClerk().getName();
            });
            pageBean.getData().forEach((it)->{
                it.getModel().getModel();
            });
            pageBean.getData().forEach((it)->{
                it.getReceiver().getName();
            });
        }else if(status==0 && client!=0){
            pageBean = orderHandler.getOrdersByClient(client, pageNo);
            pageBean.getData().forEach((it)->{
                it.getClerk().getName();
            });
            pageBean.getData().forEach((it)->{
                it.getModel().getModel();
            });
            pageBean.getData().forEach((it)->{
                it.getReceiver().getName();
            });
        }else {
            pageBean = orderHandler.getOrdersByClientAndStatus(client, status, pageNo);
            pageBean.getData().forEach((it)->{
                it.getClerk().getName();
            });
            pageBean.getData().forEach((it)->{
                it.getModel().getModel();
            });
            pageBean.getData().forEach((it)->{
                it.getReceiver().getName();
            });
        }
        return "clerkShowOrder";
    }

    public String loadClerk(){
        clerks=clerkSvc.getListByPage(pageNo);
        clerks.getData().forEach((it)->{
            //将关联实体设置为null
            it.setSalaryStandard(null);
        });
        return SUCCESS;
    }

    public PageBean<Order> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<Order> pageBean) {
        this.pageBean = pageBean;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getClerk() {
        return clerk;
    }

    public void setClerk(Integer clerk) {
        this.clerk = clerk;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer statu) {
        this.status = statu;
    }

    public PageBean<Clerk> getClerks() {
        return clerks;
    }

    public void setClerks(PageBean<Clerk> clerks) {
        this.clerks = clerks;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public PageBean<Client> getClients() {
        return clients;
    }

    public void setClients(PageBean<Client> clients) {
        this.clients = clients;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }
}

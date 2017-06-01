package controller.order;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.brand.ModelHandleSvc;
import service.clerk.ClerkBrandHandleSvc;
import service.client.IClientHandleSvc;
import service.order.OrderHandler;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ymcvalu on 2017/5/21.
 */
@Controller("addOrder")
@Scope("prototype")
public class OrderAddAction extends ActionSupport{
    private List<Client> clients;
    private List<Model> models;
    private Order order;
    private Brand brand;
    private int pageNo=0;
    private String msg;
    private String orderNo;

    @Autowired
    private OrderHandler orderSvc;
    @Autowired
    private ClerkBrandHandleSvc cbSvc;
    @Autowired
    private IClientHandleSvc clientSvc;


    @Autowired
    private ModelHandleSvc modelSvc;
    public String requestForAdd(){
        int clerk= (int)ActionContext.getContext().getSession().get("clerk");
        Clerk_Brand cb=cbSvc.getClerk_Brand(clerk);
        if(cb==null){
            msg="未推广任何品牌！";
            return "fail";
        }else{
            brand=cb.getBrand();
            brand.getName();
        }



        models=modelSvc.getListByPage(cb.getBrand().getId(),1).getData();
        if(models==null || models.size()==0){
            msg="品牌下无任何瓷砖型号信息!";
            return "fail";
        }
        clients=clientSvc.getClientsofClerkByPage(pageNo,clerk);
        if(clients==null || clients.size()==0){
            msg="没有客户信息!";
            return "fail";
        }
        return SUCCESS;
    }


    public String handlerAddReq(){
        int clerk=(int)ActionContext.getContext().getSession().get("clerk");
        orderSvc.fillOrder(order,clerk);
        ActionContext.getContext().getSession().put(order.getOrder_no(),order);
        return SUCCESS;
    }

    public String cancelOrder(){
        ActionContext.getContext().getSession().remove(order.getOrder_no());
        return "cancel";
    }

    public String commitOrder(){
        order=(Order) ActionContext.getContext().getSession().get(orderNo);
        if(order==null||orderSvc.hasOrder(orderNo)){
            msg="该订单已经提交，请勿重复提交";
        }
        else{
            orderSvc.commitOrder(order);
            msg="订单支付成功!";
        }

        ActionContext.getContext().getSession().remove(orderNo);

        return "commitSuccess";
    }

    public String commitOrderByArrear(){
        order=(Order) ActionContext.getContext().getSession().get(order.getOrder_no());
        if(order==null||orderSvc.hasOrder(order.getOrder_no())){
            msg="订单已经提交，请勿重复提交";
            return ERROR;
        }

        if(order.getReceiver().getReposal()<50){
            msg="信用值不够，暂时无法使用白条支付!";
            return ERROR;
        }

        ActionContext.getContext().getSession().remove(order.getOrder_no());
        Arrear arrear=new Arrear();
        arrear.setAmount(order.getPrice());
        arrear.setClerk(order.getClerk().getId());
        arrear.setClient(order.getReceiver().getId());
        arrear.setDate(new Date());
        Calendar c=Calendar.getInstance();
        c.add(Calendar.MONTH,1);
        arrear.setTerm(new Date(c.getTimeInMillis()));
        orderSvc.commitOrder(order,arrear);
        msg="白条支付成功!";
        return SUCCESS;
    }


    public String loadModel(){
        System.out.println(brand.getId()+" "+pageNo);
        models=modelSvc.getListByPage(brand.getId(),pageNo).getData();
        models.forEach((it)->{
            it.setBrand(null);
            it.setBatches(null);
        });
        System.out.println("fetch size:"+models.size());
        return SUCCESS;
    }

    public String loadClient(){
        int clerk= (int)ActionContext.getContext().getSession().get("clerk");
        clients=clientSvc.getClientsofClerkByPage(pageNo,clerk);
        clients.forEach((it)->{
            //将关联实体设置为null
            it.setClerk(null);
            it.setOrders(null);
        });
        return SUCCESS;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }


}

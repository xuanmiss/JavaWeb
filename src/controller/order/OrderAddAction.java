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
        brand=cb.getBrand();
        brand.getName();
        if(cb==null){
            msg="未推广任何品牌！";
            return "fail";
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

    public OrderHandler getOrderSvc() {
        return orderSvc;
    }

    public void setOrderSvc(OrderHandler orderSvc) {
        this.orderSvc = orderSvc;
    }

    public ClerkBrandHandleSvc getCbSvc() {
        return cbSvc;
    }

    public void setCbSvc(ClerkBrandHandleSvc cbSvc) {
        this.cbSvc = cbSvc;
    }



    public ModelHandleSvc getModelSvc() {
        return modelSvc;
    }

    public void setModelSvc(ModelHandleSvc modelSvc) {
        this.modelSvc = modelSvc;
    }
}

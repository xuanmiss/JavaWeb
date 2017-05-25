package controller.client;

import com.opensymphony.xwork2.ActionContext;
import entity.Clerk;
import entity.Clerk_Client;
import entity.Client;

import service.client.IClerkClientHandleSvc;
import service.client.IClientHandleSvc;
import util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import java.util.Map;




/**
 * Created by miss on 2017/5/17.
 */
@Controller("addClient")
@Scope("prototype")
public class ClientAddAction extends ActionSupport{

    private Client client;
    private Clerk clerk;
    private Clerk_Client clerkclient;// = new Clerk_Client();
    @Autowired
    private IClientHandleSvc clientSvc;
    @Autowired
    private IClerkClientHandleSvc clerkclientSvc;


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public Clerk_Client getClerkclient(){return clerkclient;}
    public void setClerkclient(Clerk_Client clerkclient){this.clerkclient = clerkclient;}

    Map<String,Object> session=ActionContext.getContext().getSession();

    @Override
    public String execute()throws Exception{

        //保存


        clientSvc.saveClient(client);
        clerkclient.setClerk((int)session.get("clerk"));
        clerkclient.setClient(client.getId());

        clerkclientSvc.saveClerkClient(clerkclient);
        return "show";
    }

    @Override
    public void validate(){

        //忽略开始空字符
        client.setName(client.getName().trim());
        client.setPhone(client.getPhone().trim());
        client.setWeichat(client.getWeichat().trim());
        client.setAddress(client.getAddress().trim());
        client.setReposal(client.getReposal());
        client.setStatus(client.getStatus());
        client.setCard(client.getCard().trim());
       // client.setSex(request.getParameter (client.getSex()));
        client.setSex(client.getSex());


        //客户姓名
        //判断是否为空
        if(StringUtil.isEmptyString(client.getName()))
            addFieldError("name", "客户姓名不能为空！");



        //客户手机号
        if(clientSvc.isExist(client.getPhone(), "phone"))
            addFieldError("phone", "该手机号已被注册！");

    }


}
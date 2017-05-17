package controller.client;

import entity.Client;
import service.client.IClientHandleSvc;
import util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;
import entity.SalaryStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import util.StringUtil;

/**
 * Created by miss on 2017/5/17.
 */
@Controller("addClient")
@Scope("prototype")
public class ClientAddAction extends ActionSupport{

    private Client client;

    @Autowired
    private IClientHandleSvc clientSvc;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String execute()throws Exception{

        //保存
        clientSvc.saveClient(client);

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
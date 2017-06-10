package controller.client;

import entity.Client;
import org.springframework.context.annotation.Scope;
import service.client.IClientHandleSvc;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import util.StringUtil;
/**
 * Created by miss on 2017/5/18.
 */

@Controller("updateClient")
@Scope("prototype")
public class ClientUpdateAction extends ActionSupport{
    @Autowired
    private IClientHandleSvc clientSvc;

    private int clientId;

    private int update = 0;

    public int getUpdate() {
        return update;
    }

    public void setUpdate(int update) {
        this.update = update;
    }

    private Client client = new Client();

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client Client) {
        this.client = client;
    }

    @Override
    public String execute(){
        if(update == 0){
            client = clientSvc.findById(clientId);
            return "update";
        }
        else{
            check();
            clientSvc.saveClient(client);
            return "show";
        }
    }

    public void check(){
        update = 0;
        //忽略开始空字符
        client.setName(client.getName().trim());
        client.setPhone(client.getPhone().trim());
        client.setAddress(client.getAddress().trim());
        client.setWeichat(client.getWeichat().trim());
        client.setCard(client.getCard().trim());

        //客户姓名
        //判断是否为空
        if(StringUtil.isEmptyString(client.getName()))
            addFieldError("name", "客户姓名不能为空！");
            //客户手机号
        else if(!client.getPhone().matches(("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$")))
            addFieldError("phone", "手机号码格式错误！");
        else if(clientSvc.isExist(client.getPhone(), "phone"))
            addFieldError("phone", "该手机号已被注册！");


    }

}

package controller.client;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Clerk_Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.client.IClerkClientHandleSvc;
import service.client.IClientHandleSvc;

import java.util.Map;

/**
 * Created by miss on 2017/5/18.
 */
@Controller("deleteClient")
@Scope("prototype")

public class ClientDeleteAction extends ActionSupport {
    @Autowired
    private IClientHandleSvc clientSvc;
    @Autowired
    private IClerkClientHandleSvc clerkclientSvc;

    private Clerk_Client clerkclient=new Clerk_Client();
    public Clerk_Client getClerkclient(){return clerkclient;}
    public void setClerkclient(Clerk_Client clerkclient){this.clerkclient = clerkclient;}

    private int clientId;
    Map<String,Object> session= ActionContext.getContext().getSession();
    @Override
    public String execute(){
        clerkclient.setClerk((int)session.get("clerk"));
        clerkclient.setClient(clientId);
        clerkclientSvc.remove(clerkclient);
        clientSvc.deleteClient(clientId);
        return "show";
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}

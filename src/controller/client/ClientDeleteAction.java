package controller.client;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.client.IClientHandleSvc;

/**
 * Created by miss on 2017/5/18.
 */
@Controller("deleteClient")
public class ClientDeleteAction extends ActionSupport {
    @Autowired
    private IClientHandleSvc clientSvc;

    private int clientId;

    @Override
    public String execute(){
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

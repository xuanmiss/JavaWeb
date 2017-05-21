package service.client;

import dao.Clerk_ClientDBAccessor;
import entity.Clerk_Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by miss on 2017/5/21.
 */
@Service
public class ClerkClientHandleSvc implements IClerkClientHandleSvc {

    @Autowired
    private Clerk_ClientDBAccessor clerkclientAcc;

    @Override
    public void saveClerkClient(Clerk_Client clerkclient){
        clerkclientAcc.insert(clerkclient);
    }
    @Override
    public void remove(Clerk_Client clerkclient){
        clerkclientAcc.getSession().delete(clerkclient);
    }
}

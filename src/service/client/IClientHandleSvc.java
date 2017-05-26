package service.client;



import entity.Client;
import util.PageBean;

import java.util.List;

/**
 * Created by miss on 2017/5/16.
 */
public interface IClientHandleSvc{
    boolean isExist(String value, String property);
    void saveClient(Client client);
    void updateClient(Client client);
    boolean deleteClient(int id);
    PageBean<Client> getListByPage(int pageNo);
    Client findById(int id);
    String getClientName(int id);
    List<Client> getClientsofClerkByPage(int pageNo,int clerk);
}

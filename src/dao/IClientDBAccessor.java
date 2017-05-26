package dao;

import entity.Client;

import java.util.List;

/**
 * Created by ymcvalu on 2017/5/6.
 */
public interface IClientDBAccessor extends IBaseDBAccessor<Client> {
    boolean isExist(String value, String property);
    String getClientName(int id);
    List<Client> getClientsOfClerkByPage(int pageNo,int rows,int clerk);

}

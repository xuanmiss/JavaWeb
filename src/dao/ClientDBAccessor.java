package dao;

import entity.Client;
import org.hibernate.Session;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by miss on 2017/5/6.
 */
@Repository("clientDBAcc")
@Lazy
public class ClientDBAccessor extends BaseDBAccessor<Client> implements IClientDBAccessor  {
    @Override
    public boolean isExist(String value, String property){
        return (long)getSession().createQuery("select count(*) from entity.Client as c where c." + property + "= ?1")
                .setString("1", value)
                .uniqueResult()>0;
    }

    @Override
    public String getClientName(int id) {
        return (String)getSession().createQuery("select c.name from entity.Client as c where c.id = ?1")
                .setInteger("1",id)
                .uniqueResult();
    }

    @Override
    public List<Client> getClientsOfClerkByPage(int pageNo, int rows, int clerk) {
        return (List<Client>)getSession().createQuery("from entity.Client as c where c.clerk.id = ?1")
                .setInteger("1",clerk)
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();

    }
}

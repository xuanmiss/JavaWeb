package dao;

import entity.Clerk_Client;
import org.hibernate.Session;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Repository("c_cDBAcc")
@Lazy
public class Clerk_ClientDBAccessor extends BaseDBAccessor<Clerk_Client> implements IClerk_ClientDBAccessor {
    @Override
    public int getContractKey(int clerk, int client) {
        Session session=getSession();
        Clerk_Client cc=(Clerk_Client) session.createQuery("from entity.Clerk_Client as  cc where  cc.clerk = ?1 and cc.client = ?2")
                .setInteger("1",clerk)
                .setInteger("2",client)
                .uniqueResult();
        if(cc!=null)
            return cc.getContract();
        else
            return 0;
    }
}

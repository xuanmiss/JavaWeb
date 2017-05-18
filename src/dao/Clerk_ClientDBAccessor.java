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
}

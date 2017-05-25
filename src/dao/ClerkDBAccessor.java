package dao;

import entity.Clerk;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * Created by ymcvalu on 2017/5/4.
 */

/**
 * 员工表访问实现类
 */
@Repository("clerkDBAcc")
@Lazy
public class ClerkDBAccessor extends BaseDBAccessor<Clerk> implements IClerkDBAccessor {

    @Override
    public void deleteById(int id){
        getSession().createQuery("delete from Clerk where id=?1").setParameter("1", id).executeUpdate();
    }

    @Override
    public boolean isExist(String value, String property){
        return (long)getSession().createQuery("select count(*) from entity.Clerk as c where c." + property + "= ?1")
                .setParameter("1", value)
                .uniqueResult()>0;
    }

}

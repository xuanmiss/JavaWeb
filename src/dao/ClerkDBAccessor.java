package dao;

import entity.Clerk;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        getSession().createQuery("delete entity.Clerk as c where c.id=?1").setParameter("1", id);
    }
}

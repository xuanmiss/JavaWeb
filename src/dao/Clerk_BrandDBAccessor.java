package dao;

import entity.Clerk_Brand;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by Administrator on 2017/5/7/007.
 */
@Repository
@Lazy
public class Clerk_BrandDBAccessor extends BaseDBAccessor<Clerk_Brand> implements  IClerk_BrandDBAccessor{
    @Override
    public void setClerkStatus(int id){
           String hql = "update entity.Clerk_Brand as c set c.status =?1 where c.id=?2";
           getSession().createQuery(hql).setInteger("1",1).setInteger("2",id).executeUpdate();
    }
    @Override
    public void setClerkStatus_2(int id){
        String hql = "update entity.Clerk_Brand as c set c.status =?1 where c.id=?2";
        getSession().createQuery(hql).setInteger("1",0).setInteger("2",id).executeUpdate();
    }
    @Override
    public void remove(int id){
        String hql = "delete entity.Clerk_Brand as c where id=?1";
        getSession().createQuery(hql).setInteger("1",id).executeUpdate();
    }
}

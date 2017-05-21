package dao;

import entity.Brand;
import entity.Clerk;
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
    /**
     * dao层的数据库支持，为添加业务表单的下拉菜单栏提供clerk数据
     **/
    public List<Clerk> getAllClerk(){
        String hql="from entity.Clerk";
        return getSession().createQuery(hql).list();
    }
    @Override
    /**
     * dao层的数据库支持，为添加业务表单的下拉菜单栏提供brand数据
     **/
    public List<Brand> getAllBrand(){
        String hql="from entity.Brand";
        return getSession().createQuery(hql).list();
    }
    @Override
    /**
     * dao层的数据库支持，在列表想改变业务状态提供数据操作支持，暂停变为进行
     **/
    public void setClerkStatus(int id){
           String hql = "update entity.Clerk_Brand as c set c.status =?1 where c.id=?2";
           getSession().createQuery(hql).setInteger("1",1).setInteger("2",id).executeUpdate();
    }
    @Override
    /**
     * ao层的数据库支持，在列表想改变业务状态提供数据操作支持，进行变为暂停
     **/
    public void setClerkStatus_2(int id){
        String hql = "update entity.Clerk_Brand as c set c.status =?1 where c.id=?2";
        getSession().createQuery(hql).setInteger("1",0).setInteger("2",id).executeUpdate();
    }
    @Override
    /**
     * dao层的数据库支持，在列表删除业务提供数据操作支持
     **/
    public void remove(int id){
        String hql = "delete entity.Clerk_Brand as c where id=?1";
        getSession().createQuery(hql).setInteger("1",id).executeUpdate();
    }

    @Override
    public Clerk_Brand getClerkBrand(int clerk) {
        return (Clerk_Brand) getSession().createQuery("from entity.Clerk_Brand as cc where cc.clerk.id=?1")
                .setInteger("1",clerk)
                .uniqueResult();
    }
}

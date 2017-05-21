package dao;

import entity.Order;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LCQ on 2017/5/7.
 */
@Repository
@Lazy
public class OrderDBAccessor extends BaseDBAccessor<Order> implements IOrderDBAccessor {
    @Override
    public List<Order> getListByPage(int state, int pageNo,int rows) {
        return (List<Order>)getSession().createQuery("from entity.Order as o where o.status = ?1")
                .setInteger("1",state)
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public List<Order> getListByPage(int clerk, int state, int pageNo,int rows) {
        return (List<Order>) getSession().createQuery("from entity.Order as o where o.clerk.id = ?1 and o.status = ?2")
                .setInteger("1",clerk)
                .setInteger("2",state)
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public int getCountOfOrder(int state) {
        return ((Long)getSession().createQuery("select count(*) from entity.Order as o where o.status = ?1")
        .setInteger("1",state)
        .uniqueResult()).intValue();
    }

    @Override
    public int getCountOfOrder(int clerk, int state) {
        return ((Long)getSession().createQuery("select count(*) from entity.Order as o where o.clerk.id =?1 and o.status = ?2")
                .setInteger("1",clerk)
                .setInteger("2",state)
                .uniqueResult()).intValue();
    }

    @Override
    public List<Order> getClerkOrders(int clerk, int pageNo, int rows) {
        return (List<Order>) getSession().createQuery("from entity.Order as o where o.clerk.id = ?1")
                .setInteger("1",clerk)
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public int getCountOfClerkOrder(int clerk) {
        return ((Long)getSession().createQuery("select count(*) from entity.Order as o where o.clerk.id =?1")
                .setInteger("1",clerk)
                .uniqueResult()).intValue();
    }
}

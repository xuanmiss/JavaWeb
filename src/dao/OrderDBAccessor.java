package dao;

import com.sun.org.apache.xpath.internal.operations.Mod;
import entity.Client;
import entity.Model;
import entity.Order;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by LCQ on 2017/5/7.
 */
@Repository("orderDbAcc")
public class OrderDBAccessor extends BaseDBAccessor<Order> implements IOrderDBAccessor {
    @Override
    public List<Order> getListByPageOrderByDate(int pageNo,int rows){
        return getSession().createQuery("from entity.Order order by date")
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public List<Order> getListByPageClerkOrder(int clerkId, int pageNo, int rows) {
        return getSession().createQuery("from entity.Order as o where o.clerk.id = ?1 order by date")
                .setParameter("1",clerkId)
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

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

    @Override
    public boolean hasOrderByClerk(int id) {
        return ((Long)getSession().createQuery("select count(*) from entity.Order as o where o.clerk.id =?1")
                .setInteger("1",id)
                .uniqueResult()).intValue()>0;
    }

    @Override
    public boolean hasOrderByClient(int id) {
        return ((Long)getSession().createQuery("select count(*) from entity.Order as o where o.receiver.id =?1")
                .setInteger("1",id)
                .uniqueResult()).intValue()>0;
    }


    @Autowired
    private IModelDBAccessor mdb;

    @Autowired
    private IClientDBAccessor cdb;

    @Override
    public List undoneOrders(int pageNo, int rows) {
        List list=getSession().createSQLQuery("select o.id,o.order_no,o.model,o.quantity,o.date,o.receiver,max(s.count) count from order_form o left OUTER JOIN batch b on o.model=b.model AND o.status=1 LEFT OUTER JOIN stock s on b.id=s.batch GROUP by o.model")
                .addScalar("id",StandardBasicTypes.INTEGER)
                .addScalar("order_no", StandardBasicTypes.STRING)
                .addScalar("model", StandardBasicTypes.INTEGER)
                .addScalar("quantity",StandardBasicTypes.INTEGER)
                .addScalar("date",StandardBasicTypes.DATE)
                .addScalar("receiver",StandardBasicTypes.INTEGER)
                .addScalar("count",StandardBasicTypes.INTEGER)
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
        List ret=new LinkedList();

        list.forEach((it)->{
            Object[]arr=(Object[])it;
            Order o=new Order();
            o.setId((Integer)arr[0]);
            o.setOrder_no((String)arr[1]);
            o.setModel(mdb.getObj(Model.class,(int)arr[2]));
            o.setQuantity((int)arr[3]);
            o.setDate((Date)arr[4]);
            o.setReceiver(cdb.getObj(Client.class,(int)arr[5]));
            Integer count=(Integer)arr[6];
            Object[]obj=new Object[]{o,count};
            ret.add(obj);
        });
        return ret;

    }
}

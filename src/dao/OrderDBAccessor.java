package dao;

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
    public List<Order> getListByPageModelOrder(int modelId, int pageNo, int rows) {
        return getSession().createQuery("from entity.Order as o where o.model.id = ?1 order by date")
                .setParameter("1",modelId)
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
    public int getCountOfOrderModel(int model) {
        return ((Long)getSession().createQuery("select count(*) from entity.Order as o where o.model.id =?1")
                .setInteger("1",model)
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

    @Override
    public boolean hasOrder(String orderNo){
        return ((Long)getSession().createQuery("select count(*) from entity.Order as o where o.order_no = ?1")
            .setString("1",orderNo)
            .uniqueResult())>0;
    }


    @Autowired
    private IModelDBAccessor mdb;

    @Autowired
    private IClientDBAccessor cdb;

    @Override
    public List<Object[]> undoneOrders(int pageNo, int rows) {
        List list=getSession().createSQLQuery("select o.id,o.order_no,o.model,o.quantity,o.date,o.receiver,b.count " +
                "from order_form o left outer join b_s b on o.model = b.model")
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
        List<Object[]> ret=new LinkedList();
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

    @Override
    public Order getOrder(String orderNo) {
        return (Order)getSession().createQuery("select o from entity.Order as o where o.order_no = ?1")
                .setString("1",orderNo)
                .uniqueResult();
    }



    @Override
    public List<Order> getListByPage(int clerk, int client, int state, int pageNo, int rows) {
        return getSession().createQuery("select o from entity.Order as o where o.clerk.id = ?1 and o.receiver.id = ?2 and o.status = ?3")
                .setInteger("1",clerk)
                .setInteger("2",client)
                .setInteger("3",state)
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public List<Order> getLIstByClerkAndClient(int clerk, int client, int pageNo, int rows) {
        return getSession().createQuery("select o from entity.Order as o where o.clerk.id = ?1 and o.receiver.id = ?2 ")
                .setInteger("1",clerk)
                .setInteger("2",client)

                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }



    @Override
    public List<Order> getListByClient(int client, int state, int pageNo, int rows) {
        return getSession().createQuery("select o from entity.Order as o where o.receiver.id = ?1 and o.status = ?2")
                .setInteger("1",client)
                .setInteger("2",state)
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public List<Order> getListByClient(int client, int pageNo, int rows) {
        return getSession().createQuery("select o from entity.Order as o where o.receiver.id = ?1")
                .setInteger("1",client)
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public int getCountByClerkAndClientAndState(int clerk, int client, int state) {
        return ((Long)getSession().createQuery("select count(*) from entity.Order as o where o.clerk.id=?1 and o.receiver.id=?2 and o.status=?3")
                .setInteger("1",clerk)
                .setInteger("2",client)
                .setInteger("3",state)
                .uniqueResult()).intValue();
    }

    @Override
    public int getCountByClerkAndClient(int clerk, int client) {
        return ((Long)getSession().createQuery("select count(*) from entity.Order as o where o.clerk.id=?1 and o.receiver.id=?2")
                .setInteger("1",clerk)
                .setInteger("2",client)

                .uniqueResult()).intValue();
    }

    @Override
    public int getCountByClinetANdState(int client, int state) {
        return ((Long)getSession().createQuery("select count(*) from entity.Order as o where o.receiver.id=?1 and o.status=?2")
                .setInteger("1",client)
                .setInteger("2",state)
                .uniqueResult()).intValue();
    }

    @Override
    public int getCountByClient(int client) {
        return ((Long)getSession().createQuery("select count(*) from entity.Order as o where o.receiver.id=?1 ")
                .setInteger("1",client)
                .uniqueResult()).intValue();
    }
}


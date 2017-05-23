package dao;

import entity.Batch;
import entity.Clerk;
import entity.Order;
import entity.Purchase;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by LCQ on 2017/5/7.
 */
@Repository
@Lazy
public class PurchaseDBAccessor extends BaseDBAccessor<Purchase> implements IPurchaseDBAccessor{
       /**
        * 提供批次 业务员、订单的入库下拉栏菜单数据支持
        * */
       @Override
       public List<Batch> getBatchList(){
           String hql = "from entity.Batch";
           return getSession().createQuery(hql).list();
       }
       @Override
       public List<Clerk> getClerkList(){
           String hql = "from entity.Clerk";
           return getSession().createQuery(hql).list();
       }
       @Override
       public List<Order> getOrderList(){
           String hql = "from entity.Order";
           return getSession().createQuery(hql).list();
       }

       /**
        * 清除记录
        **/
       @Override
       public void remove(int id){
           String hql = "delete entity.Purchase as p where p.id=?1";
           getSession().createQuery(hql).setInteger("1",id).executeUpdate();
       }

      /* public Batch findBatchById(int batchId){
           String hql = "from entity.Batch as b where b.id=?1";
           return (Batch)getSession().createQuery(hql).setInteger("1",batchId).uniqueResult();

       }
       public Clerk findClerkById(int clerkId){
           String hql = "from entity.Clerk as c where c.id=?1";
           return (Clerk) getSession().createQuery(hql).setInteger("1",clerkId).uniqueResult();
       }
       public Order findOrderById(int orderId){
           String hql = "from entity.Order as o where o.id=?1";
           return (Order) getSession().createQuery(hql).setInteger("1",orderId).uniqueResult();
       }*/

}

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
       public List<Batch> getBatchList(){
           String hql = "from entity.Batch";
           return getSession().createQuery(hql).list();
       }

       public List<Clerk> getClerkList(){
           String hql = "from entity.Clerk";
           return getSession().createQuery(hql).list();
       }

       public List<Order> getOrderList(){
           String hql = "from entity.Order";
           return getSession().createQuery(hql).list();
       }

}

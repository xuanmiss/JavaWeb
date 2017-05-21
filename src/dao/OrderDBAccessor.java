package dao;

import entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LCQ on 2017/5/7.
 */
@Repository("orderDbAcc")
public class OrderDBAccessor extends BaseDBAccessor<Order> implements IOrderDBAccessor {
    @Override
    public List<Order> getListByPageOrderByDate(int pageNo,int rows){
        return getSession().createQuery("from Order order by date")
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }
    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public List<Order> findByDate(Object object) {
        return null;
    }


    @Override
    public List<Order> findByName(Object object) {
        return null;
    }

    @Override
    public Class<Order> findByOrderNo(Object object) {
        return null;
    }

    @Override
    public List<Order> findByStatus(Object object) {
        return null;
    }

    @Override
    public List<Order> findByModel(Object object) {
        return null;
    }
}

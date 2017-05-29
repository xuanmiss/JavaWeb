package dao;

import entity.Purchase_Order;
import org.springframework.stereotype.Repository;
import util.PageBean;

import java.util.List;


@Repository("purchaseOrderDBAcc")
public class PurchaseOrderDBAccessor extends BaseDBAccessor<Purchase_Order> implements IPurchaseOrderDBAccessor{



    @Override
    public List<Purchase_Order> getListByPageOrderByDate(int pageNo, int rows) {
        return getSession().createQuery("from entity.Purchase_Order order by date")
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public List<Purchase_Order> getUndoPurchaseByPage(int pageNo, int rows) {
        return getSession().createQuery("select po from entity.Purchase_Order as po where po.type = 1 or po.type = 3")
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public int countOfUndoPurchase() {
        return ((Long)getSession().createQuery("select count(*) from entity.Purchase_Order as po where po.type = 1 or po.type = 3")
                .uniqueResult()).intValue();
    }

    @Override
    public void setPurchaseOrderType(Purchase_Order order) {
        order.setType(order.getType()+2);
    }

    @Override
    public Purchase_Order getOrderByOrderNo(String orderNo) {
        return (Purchase_Order) getSession().createQuery("select o from entity.Purchase_Order as o where o.order_no = ?1")
                .setString("1",orderNo)
                .uniqueResult();
    }

    @Override
    public List<Purchase_Order> getListByBrandAndModelDesc(int brandId, int modelId, int pageNo, int rows) {
        return getSession().createQuery("select o from  entity.Purchase_Order as o where o.model.brand.id = ?1 and o.model.id = ?2 order by o.date desc")
                .setInteger("1", brandId)
                .setInteger("2", modelId)
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public List<Purchase_Order> getListByBrandAndModelAsc(int brandId, int modelId, int pageNo, int rows) {
        return getSession().createQuery("select o from  entity.Purchase_Order as o where o.model.brand.id = ?1 and o.model.id = ?2 order by o.date asc")
                .setInteger("1", brandId)
                .setInteger("2", modelId)
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public List<Purchase_Order> getListByBrandDesc(int brandId, int pageNo, int rows) {
        return getSession().createQuery("select o from  entity.Purchase_Order as o where o.model.brand.id = ?1 order by o.date desc")
                .setInteger("1", brandId)
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public List<Purchase_Order> getListByBrandAsc(int brandId, int pageNo, int rows) {
        return getSession().createQuery("select o from  entity.Purchase_Order as o where o.model.brand.id = ?1 order by o.date asc")
                .setInteger("1", brandId)
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public List<Purchase_Order> getListByDesc(int pageNo, int rows) {
        return getSession().createQuery("from entity.Purchase_Order order by date desc")
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public List<Purchase_Order> getListByAsc(int pageNo, int rows) {
        return getSession().createQuery("from entity.Purchase_Order order by date asc ")
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }
}

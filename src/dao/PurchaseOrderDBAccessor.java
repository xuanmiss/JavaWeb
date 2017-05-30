package dao;

import entity.Purchase_Order;
import org.springframework.stereotype.Repository;

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
    public List<Purchase_Order> getUndoListByBrandAndModelDesc(int brandId, int modelId, int pageNo, int rows) {
        return getSession().createQuery("select o from  entity.Purchase_Order as o where o.model.brand.id = ?1 and o.model.id = ?2 and (o.type = 1 or o.type = 3) order by o.date desc")
                .setInteger("1", brandId)
                .setInteger("2", modelId)
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public List<Purchase_Order> getUndoListByBrandAndModelAsc(int brandId, int modelId, int pageNo, int rows) {
        return getSession().createQuery("select o from  entity.Purchase_Order as o where o.model.brand.id = ?1 and o.model.id = ?2 and (o.type = 1 or o.type = 3) order by o.date")
                .setInteger("1", brandId)
                .setInteger("2", modelId)
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public List<Purchase_Order> getUndoListByBrandDesc(int brandId, int pageNo, int rows) {
        return getSession().createQuery("select o from  entity.Purchase_Order as o where o.model.brand.id = ?1 and (o.type = 1 or o.type = 3)  order by o.date desc")
                .setInteger("1", brandId)
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public List<Purchase_Order> getUndoListByBrandAsc(int brandId, int pageNo, int rows) {
        return getSession().createQuery("select o from  entity.Purchase_Order as o where o.model.brand.id = ?1 and (o.type = 1 or o.type = 3)  order by o.date")
                .setInteger("1", brandId)
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public List<Purchase_Order> getUndoListByDesc(int pageNo, int rows) {
        return getSession().createQuery("from entity.Purchase_Order where   type = 1 or  type = 3   order by date desc")
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public List<Purchase_Order> getUndoListByAsc(int pageNo, int rows) {
        return getSession().createQuery("from entity.Purchase_Order where  type = 1 or  type = 3  order by date ")
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }

    @Override
    public int getUndoCountByBrand(int brandId) {
        return ((Long)getSession().createQuery("select count(*) from  entity.Purchase_Order as o where o.model.brand.id = ?1 and (o.type = 1 or o.type = 3) ")
                .setInteger("1",brandId)
                .uniqueResult()).intValue();
    }

    @Override
    public int getUndoCountByBrandAndModel(int brandId, int modelId) {
        return getUndoCountByModel(modelId);
    }

    @Override
    public int getUndoCountByModel(int modelId) {
        return ((Long)getSession().createQuery("select count(*) from  entity.Purchase_Order as o where o.model.id = ?1 and (o.type = 1 or o.type = 3) ")
                .setInteger("1",modelId)
                .uniqueResult()).intValue();
    }
}

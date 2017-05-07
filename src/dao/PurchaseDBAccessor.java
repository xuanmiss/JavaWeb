package dao;

import entity.Purchase;

import java.util.List;

/**
 * Created by LCQ on 2017/5/7.
 */
public class PurchaseDBAccessor extends BaseDBAccessor<Purchase> implements IPurchaseDBAccessor{
    @Override
    public List<Purchase> findByBatch(Object object) {
        return null;
    }

    @Override
    public List<Purchase> findByClerk(Object object) {
        return null;
    }

    @Override
    public List<Purchase> findByOrderNo(Object object) {
        return null;
    }
}

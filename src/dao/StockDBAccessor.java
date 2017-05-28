package dao;

import entity.Stock;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/6 0006.
 */
@Repository("stockDBAcc")
@Lazy
public class StockDBAccessor extends BaseDBAccessor<Stock> implements IStockDBAccessor{
    @Override
    public List<Stock> findStockByModelWithQuantityLimit(int quantity, int model) {
        return getSession().createQuery("select s from entity.Stock as s where s.batch.model.id = ?1 and s.count >= ?2")
                .setInteger("1",model)
                .setInteger("2",quantity)
                .list();
    }
    @Override
    public Stock findByBatch(int batchId){
        return (Stock)getSession().createQuery("from entity.Stock as s where s.batch=?1")
                .setInteger("1", batchId)
                .uniqueResult();
    }
}

package dao;

import entity.Batch;
import entity.Stock;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/6 0006.
 */
@Repository("batchDBAcc")

public class BatchDBAccessor extends BaseDBAccessor<Batch> implements IBatchDBAccessor{
    @Override
    public int countOfModel(int modelId) {
        Long l=(long)getSession().createQuery("select count(*) from entity.Batch as b where b.model.id = ?1")
                .setInteger("1",modelId)
                .uniqueResult();
        return l.intValue();
    }
    @Override
    public List<Stock> findStockByBatch(int batch_no){
        return getSession().createQuery("from entity.Stock as s where s.batch=?1")
                .setParameter("1", batch_no)
                .list();
    }
    @Override
    public List<Batch> findByModel(int model_id){
        return getSession().createQuery("from entity.Batch as b where b.model=?1")
                .setParameter("1", model_id)
                .list();
    }
    @Override
    public void saveBatch(Batch batch){
        getSession().save(batch);
    }
    @Override
    public Batch findById(int id){
        return (Batch) getSession().createQuery("from entity.Batch as b where b.id=?1")
                .setParameter("1", id)
                .uniqueResult();
    }

    @Override
    public List<Batch> getBatchByModel(int modelId){
        String hql = "from entity.Batch as b where b.model=?1";
        return getSession().createQuery(hql)
                .setInteger("1", modelId)
                .list();
    }


}

package dao;

import entity.Batch;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/5/6 0006.
 */
@Repository("batchDBAcc")
@Lazy
public class BatchDBAccessor extends BaseDBAccessor<Batch> implements IBatchDBAccessor{
    @Override
    public int countOfModel(int modelId) {
        Long l=(long)getSession().createQuery("select count(*) from entity.Batch as b where b.model.id = ?1")
                .setInteger("1",modelId)
                .uniqueResult();
        return l.intValue();
    }



}

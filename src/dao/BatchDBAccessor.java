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

}

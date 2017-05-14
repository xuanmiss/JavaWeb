package dao;

import entity.Batch;

/**
 * Created by Administrator on 2017/5/6 0006.
 */
public interface IBatchDBAccessor extends IBaseDBAccessor<Batch> {

    int countOfModel(int modelId);
}

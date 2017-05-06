package dao;

import entity.Batch;

/**
 * Created by Administrator on 2017/5/6 0006.
 */
public interface IBatchDBAccessor extends IBaseDBAccessor<Batch> {
    /**
     * 获取指定批号
     * @param batch_no
     * @param date
     * @return 如果存在返回主键，否则返回0
     */
}

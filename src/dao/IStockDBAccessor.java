package dao;

import entity.Stock;

/**
 * Created by Administrator on 2017/5/6 0006.
 */
public interface IStockDBAccessor extends IBaseDBAccessor<Stock>{
    /**
     * 获取库存数量
     * @param count
     * @return 如果存在返回主键，否则返回0
     */

}

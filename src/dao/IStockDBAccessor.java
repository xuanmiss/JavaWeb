package dao;

import entity.Stock;

import java.util.List;

/**
 * Created by Administrator on 2017/5/6 0006.
 */
public interface IStockDBAccessor extends IBaseDBAccessor<Stock>{
    List<Stock> findBatchByModelWithQuantityLimit(int quantity, int model);

}

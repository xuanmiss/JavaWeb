package service.stock;

import entity.Stock;

import java.util.List;

/**
 * Created by Administrator on 2017/5/28.
 */
public interface IStockSvc {
    List<Stock> findStockByModelWithQuantityLimit(int quantity, int model);
    Stock findByBatch(int batchId);
}

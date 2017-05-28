package service.stock;

import dao.IStockDBAccessor;
import entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/28.
 */
@Service("stockSvc")
public class StockSvc implements IStockSvc{
    @Autowired
    private IStockDBAccessor stockDBAccessor;

    public List<Stock> findStockByModelWithQuantityLimit(int quantity, int model){
        return stockDBAccessor.findStockByModelWithQuantityLimit(quantity, model);
    }

    public Stock findByBatch(int batchId){
        return stockDBAccessor.findByBatch(batchId);
    }
}

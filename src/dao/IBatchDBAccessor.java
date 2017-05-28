package dao;

import entity.Batch;
import entity.Stock;

import java.util.List;

/**
 * Created by Administrator on 2017/5/6 0006.
 */
public interface IBatchDBAccessor extends IBaseDBAccessor<Batch> {

    int countOfModel(int modelId);
    List<Stock> findStockByBatch(int batch_no);
    List<Batch> findByModel(int model_id);
    void saveBatch(Batch batch);
    Batch findById(int id);
    //通过型号查找批次
    List<Batch> getBatchByModel(int ModelId);
}

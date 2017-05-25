package service.batch;

import entity.Batch;
import entity.Stock;
import util.PageBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */
public interface IBatchHandleService {
    List<Stock> findStockByBatch(int batch_no);
    List<Batch> findByModel(int model_id);
    void saveBatch(Batch batch);
    Batch findById(int id);
    PageBean<Batch> getListByPage(int pageNo);
}

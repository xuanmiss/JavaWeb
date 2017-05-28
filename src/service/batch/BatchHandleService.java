package service.batch;

import dao.IBatchDBAccessor;
import entity.Batch;
import entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import util.PageBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */
public class BatchHandleService implements IBatchHandleService{
    @Autowired
    IBatchDBAccessor batchDBAccessor;
    @Override
    public List<Stock> findStockByBatch(int batch_no){
        return batchDBAccessor.findStockByBatch(batch_no);
    }
    @Override
    public List<Batch> findByModel(int model_id){
        return batchDBAccessor.findByModel(model_id);
    }
    @Override
    public void saveBatch(Batch batch){
        batchDBAccessor.saveBatch(batch);
    }
    @Override
    public PageBean<Batch> getListByPage(int pageNo){
        PageBean<Batch> pb=new PageBean<>();
        pb.setCurPage(pageNo);
        pb.setMaxRowCount(batchDBAccessor.getCount(Batch.class));
        pb.setData(batchDBAccessor.getListByPage(Batch.class,pageNo,pb.getRowsPerPage()));
        return pb;
    }
    @Override
    public Batch findById(int id){
        return batchDBAccessor.findById(id);
    }

    @Override
    public List<Batch> getBatchByModel(int ModelId){
        return batchDBAccessor.getBatchByModel(ModelId);
    }
}

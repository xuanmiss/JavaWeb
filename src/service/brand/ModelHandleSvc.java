package service.brand;

import dao.IModelDBAccessor;
import entity.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PageBean;

import java.util.List;

/**
 * Created by ymcvalu on 2017/5/13.
 */
@Service
public class ModelHandleSvc implements IModelHandleSvc{
    @Autowired
    private IModelDBAccessor modelAcc;

    @Override
    public PageBean<Model> getListByPage(int brand, int pageNo) {
        PageBean<Model> pb=new PageBean<>();
        pb.setCurPage(pageNo);
        pb.setMaxRowCount(modelAcc.getCount(Model.class));
        pb.setData(modelAcc.getListByPage(brand,pageNo,pb.getRowsPerPage()));
        return pb;
    }

    @Override
    public Model getModelById(int brand, int id) {
        return modelAcc.getModelById(brand,id);
    }

    @Override
    public boolean isExist(String model,int brandId) {
        return modelAcc.isExist(model,brandId);
    }

    @Override
    public void saveModel(Model model) {
        modelAcc.insert(model);
    }

    public IModelDBAccessor getModelAcc() {
        return modelAcc;
    }

    public void setModelAcc(IModelDBAccessor modelAcc) {
        this.modelAcc = modelAcc;
    }
}

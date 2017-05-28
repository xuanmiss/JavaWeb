package dao;

import entity.Model;

import java.util.List;

/**
 * Created by chenshihong on 2017/5/7.
 */
public interface IModelDBAccessor extends IBaseDBAccessor<Model> {
    List<Model> getListByPage(int brand,int pageNo,int rows);
    Model getModelById(int brand,int id);
    boolean isExist(String model,int brandId);
    List<Model> getListofAll();
    int getModelCountByBrand(int brandId);
    List<Model> getModelByBrand(int brandId);

}

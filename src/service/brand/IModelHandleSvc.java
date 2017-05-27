package service.brand;

import entity.Model;
import util.PageBean;

import java.util.List;

/**
 * Created by ymcvalu on 2017/5/13.
 */
public interface IModelHandleSvc {
    PageBean<Model> getListByPage(int brand, int pageNo);
    Model getModelById(int brand,int id);
    boolean isExist(String model,int brandId);
    void saveModel(Model model);
    void updateModel(Model model);
    boolean delect(int modelId);
    Model getModel(int id);
    List<Model> getListModelofAll();
}

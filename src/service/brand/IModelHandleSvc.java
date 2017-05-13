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
}

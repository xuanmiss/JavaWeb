package dao;

import entity.Brand;

import java.util.List;

/**
 * Created by Administrator on 2017/5/7/007.
 */
public interface IBrandDBAccessor  extends IBaseDBAccessor<Brand> {
    boolean isExist(String name);
    String getBrandName(int id);
    Boolean isExitModel(int brandId);
    //获取所有品牌
    List<Brand> getAll();
}

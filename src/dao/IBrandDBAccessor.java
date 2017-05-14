package dao;

import entity.Brand;

/**
 * Created by Administrator on 2017/5/7/007.
 */
public interface IBrandDBAccessor  extends IBaseDBAccessor<Brand> {
    boolean isExist(String name);
    String getBrandName(int id);
    Boolean isExitModel(int brandId);
}

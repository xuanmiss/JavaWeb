package service.brand;

import entity.Brand;
import util.PageBean;

/**
 * Created by ymcvalu on 2017/5/9.
 */
public interface IBrandHandleSvc {
    boolean isExist(String name);
    void saveBrand(Brand brand);
    PageBean<Brand> getListByPage(int pageNo);
    Brand findById(int id);
    String getBrandName(int id);
}

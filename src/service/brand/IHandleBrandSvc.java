package service.brand;

import entity.Brand;

/**
 * Created by ymcvalu on 2017/5/9.
 */
public interface IHandleBrandSvc {
    boolean isExist(String name);
    void saveBrand(Brand brand);
}

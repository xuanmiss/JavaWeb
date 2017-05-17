package dao;

import entity.Brand;
import entity.Clerk;
import entity.Clerk_Brand;

import java.util.List;


/**
 * Created by Administrator on 2017/5/7/007.
 */
public interface IClerk_BrandDBAccessor extends  IBaseDBAccessor<Clerk_Brand> {
    void setClerkStatus(int id);
    void setClerkStatus_2(int id);
    void remove(int id);
    List<Clerk> getAllClerk();
    List<Brand> getAllBrand();
}

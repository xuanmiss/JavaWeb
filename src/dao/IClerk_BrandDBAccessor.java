package dao;

import entity.Clerk_Brand;


/**
 * Created by Administrator on 2017/5/7/007.
 */
public interface IClerk_BrandDBAccessor extends  IBaseDBAccessor<Clerk_Brand> {
    void setClerkStatus(int id);
    void setClerkStatus_2(int id);
    void remove(int id);
}

package service.clerk;

import entity.Brand;
import entity.Clerk;
import entity.Clerk_Brand;
import util.PageBean;

import java.util.List;

/**
 * Created by LCQ on 2017/5/14.
 */
public interface IClerkBrandHandleSvc<T> {
    PageBean<T> getListByPage(int pageNo);
    void saveClerkBrand(Clerk_Brand clerkBrand);
    List<Clerk> formClerkOpition();
    List<Brand> formBrandOpition();
    void setClerkStatus(int id);
    void setClerkStatus_2(int id);
    void remove(int id);
}

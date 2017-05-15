package service.clerk;

import entity.Brand;
import entity.Clerk;
import entity.Clerk_Brand;
import util.PageBean;

/**
 * Created by LCQ on 2017/5/14.
 */
public interface IClerkBrandHandleSvc<T> {
    PageBean<T> getListByPage(int pageNo);
    void saveClerkBrand(Clerk_Brand clerkBrand);
    PageBean<Clerk> formClerkOpition(int pageNo);
    PageBean<Brand> formBrandOpition(int pageNo);

}

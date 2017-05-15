package service.clerk;


import dao.BrandDBAccessor;
import dao.ClerkDBAccessor;
import dao.Clerk_BrandDBAccessor;
import entity.Brand;
import entity.Clerk;
import entity.Clerk_Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PageBean;


/**
 * Created by LCQ on 2017/5/14.
 */
@Service
public class ClerkBrandHandleSvc implements IClerkBrandHandleSvc {
    @Autowired
    private Clerk_BrandDBAccessor clerkBrandDBAccessor;
    @Autowired
    private ClerkDBAccessor clerkDBAccessor;
    @Autowired
    private BrandDBAccessor brandDBAccessor;

    @Override
    public void saveClerkBrand(Clerk_Brand clerkBrand){
        clerkBrandDBAccessor.insert(clerkBrand);
    }

    public void setClerkStatus(int id){
        clerkBrandDBAccessor.setClerkStatus(id);
    }

    public void setClerkStatus_2(int id){
        clerkBrandDBAccessor.setClerkStatus_2(id);
    }

    public void remove(int id){
        clerkBrandDBAccessor.remove(id);
    }

    @Override
    public PageBean<Clerk_Brand> getListByPage(int pageNo){
        PageBean<Clerk_Brand> pageBean = new PageBean<>();
        pageBean.setCurPage(pageNo);
        pageBean.setMaxRowCount(clerkBrandDBAccessor.getCount(Clerk_Brand.class));
        pageBean.setData(clerkBrandDBAccessor.getListByPage(Clerk_Brand.class,pageNo,pageBean.getRowsPerPage()));
        return pageBean;
    }
    /**
     * 实现表单下拉菜单栏的数据称支持（尚未实现）
     **/
    @Override
    public PageBean<Clerk> formClerkOpition(int pageNo){
        PageBean<Clerk> pageBean = new PageBean<>();
        pageBean.setCurPage(pageNo);
        pageBean.setMaxRowCount(clerkDBAccessor.getCount(Clerk.class));
        pageBean.setData(clerkDBAccessor.getListByPage(Clerk.class,pageNo,pageBean.getRowsPerPage()));
        return pageBean;
    }
    /**
     * 实现表单下拉菜单栏的数据称支持（尚未实现）
     **/
    @Override
    public PageBean<Brand> formBrandOpition(int pageNo){
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setCurPage(pageNo);
        pageBean.setMaxRowCount(brandDBAccessor.getCount(Brand.class));
        pageBean.setData(brandDBAccessor.getListByPage(Brand.class,pageNo,pageBean.getRowsPerPage()));
        return pageBean;
    }


}

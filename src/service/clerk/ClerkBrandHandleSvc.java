package service.clerk;


import dao.Clerk_BrandDBAccessor;
import entity.Brand;
import entity.Clerk;
import entity.Clerk_Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PageBean;
import java.util.List;


/**
 * Created by LCQ on 2017/5/14.
 */
@Service("clerkBrand")
public class ClerkBrandHandleSvc implements IClerkBrandHandleSvc {
    @Autowired
    /**
     * spring DAO对象的自动注入
     */
    private Clerk_BrandDBAccessor clerkBrandDBAccessor;

    @Override
    /**
     * 添加业务的服务层支持，调用dao层的数据库操作支持
     **/
    public void saveClerkBrand(Clerk_Brand clerkBrand){
        clerkBrandDBAccessor.getSession().save(clerkBrand);
    }
    /**
     * 添加业务的服务层支持，调用dao层的数据库操作支持
     **/
    @Override
    /**
     * 修改业务状态的服务层支持，调用dao层的数据库支持
     **/
    public void setClerkStatus(int id){
        clerkBrandDBAccessor.setClerkStatus(id);
    }
    @Override
    /**
     * 修改业务状态的服务层支持，调用dao层的数据库支持
     **/
    public void setClerkStatus_2(int id){
        clerkBrandDBAccessor.setClerkStatus_2(id);
    }
    @Override
    /**
     * 删除业务的服务层支持，调用dao层的数据库支持
     */
    public void remove(int id){
        clerkBrandDBAccessor.remove(id);
    }

    @Override
    /**
     * 获取全部业务的服务层支持，调用dao层的数据库支持
     **/
    public PageBean<Clerk_Brand> getListByPage(int pageNo){
        PageBean<Clerk_Brand> pageBean = new PageBean<>();
        pageBean.setCurPage(pageNo);
        pageBean.setMaxRowCount(clerkBrandDBAccessor.getCount(Clerk_Brand.class));
        pageBean.setData(clerkBrandDBAccessor.getListByPage(Clerk_Brand.class,pageNo,pageBean.getRowsPerPage()));
        return pageBean;
    }
    @Override
    /**
     * 表单业务员下拉栏的服务层支持，调用dao层的数据库支持
     */
    public List<Clerk> formClerkOpition(){
        List<Clerk> clerkList = clerkBrandDBAccessor.getAllClerk();
        return clerkList;

    }
    @Override
    /**
     * 表单品牌下拉栏的服务层支持，调用dao层的数据库支持
     */
    public List<Brand> formBrandOpition(){
        List<Brand> brandList = clerkBrandDBAccessor.getAllBrand();
        return brandList;

    }

    @Override
    public Clerk_Brand getClerk_Brand(int clerk) {
        return clerkBrandDBAccessor.getClerkBrand(clerk);
    }
}

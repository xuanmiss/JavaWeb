package controller.clerk;

import com.opensymphony.xwork2.ActionSupport;
import entity.Brand;
import entity.Clerk;
import entity.Clerk_Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.clerk.ClerkBrandHandleSvc;
import util.PageBean;

import java.util.Date;
import java.util.List;

/**
 * Created by LCQ on 2017/5/14.
 */
@Controller("ClerkBrand")
@Scope("prototype")
public class ClerkBrandAction extends ActionSupport{
    @Autowired
    private ClerkBrandHandleSvc clerkBrandHandleSvc;
    private Clerk_Brand clerkBrand;
    private Brand brand;
    private Clerk clerk;
    private int id;
    int pageNo = 1;
    PageBean<Clerk_Brand> pageBean = null;
    List<Clerk> clerkList = null;
    List<Brand> brandList = null;
    /**
     * 获取业务表的Action
     **/
    public String select(){
        pageBean = clerkBrandHandleSvc.getListByPage(pageNo);
        return SUCCESS;
    }
    /**
     * 功能描述：
     * 新增或修改业务员推广品牌信息
     * modify by ymcvalu
     * bug fix: a clerk only can bind with a brand
     * */
    public String save(){
        //get the record
        Clerk_Brand cb=clerkBrandHandleSvc.getClerk_Brand(clerk.getId());
        // if null,add
        if(cb==null){
            clerkBrand.setClerk(clerk);
            clerkBrand.setBrand(brand);
            clerkBrand.setDate(new Date());
            clerkBrandHandleSvc.saveClerkBrand(clerkBrand);
        }else{  //not null,update
            //auto update when transaction commit
            cb.setStatus(clerkBrand.getStatus());
            cb.setBrand(brand);
            cb.setDate(new Date());

        }
        return SUCCESS;
    }
    /**
     * 开始业务的Action
     * */
    public String begin(){
        clerkBrandHandleSvc.setClerkStatus(id);
        return SUCCESS;
    }
    /**
     * 停止业务状态的Action
     * */
    public String stop(){
        clerkBrandHandleSvc.setClerkStatus_2(id);
        return SUCCESS;
    }
    /**
     * 移除业务的Action
     **/
    public String remove(){

        clerkBrandHandleSvc.remove(id);
        return SUCCESS;
    }
    /**
     *调用服务层的方法获取业务表和品牌表，为下拉菜单提供数据
     **/
    public String formOpition(){
         clerkList= clerkBrandHandleSvc.formClerkOpition();
         brandList= clerkBrandHandleSvc.formBrandOpition();
         setClerkList(clerkList);
         setBrandList(brandList);
        return SUCCESS;
    }


    /**
     * 下列均是Action的对象的set get方法
     * */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;}

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public PageBean<Clerk_Brand> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<Clerk_Brand> pageBean) {
        this.pageBean = pageBean;
    }

    public Clerk_Brand getClerkBrand() {
        return clerkBrand;
    }

    public void setClerkBrand(Clerk_Brand clerkBrand) {
        this.clerkBrand = clerkBrand;
    }

    public ClerkBrandHandleSvc getClerkBrandHandleSvc() {
        return clerkBrandHandleSvc;
    }

    public void setClerkBrandHandleSvc(ClerkBrandHandleSvc clerkBrandHandleSvc) {
        this.clerkBrandHandleSvc = clerkBrandHandleSvc;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Clerk> getClerkList() {
        return clerkList;
    }

    public void setClerkList(List<Clerk> clerkList) {
        this.clerkList = clerkList;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }
}

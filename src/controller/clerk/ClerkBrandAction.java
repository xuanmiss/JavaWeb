package controller.clerk;

import com.opensymphony.xwork2.ActionSupport;
import entity.Brand;
import entity.Clerk;
import entity.Clerk_Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.clerk.ClerkBrandHandleSvc;
import util.PageBean;

/**
 * Created by LCQ on 2017/5/14.
 */
@Controller("ClerkBrand")
public class ClerkBrandAction extends ActionSupport{
    @Autowired
    private ClerkBrandHandleSvc clerkBrandHandleSvc;
    private Clerk_Brand clerkBrand;
    private String clerkName;
    private String brandName;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;}

    int pageNo = 1;
    PageBean<Clerk_Brand> pageBean = null;
    PageBean<Clerk> pageBean1 = null;
    PageBean<Brand> pageBean2 = null;

    public String select(){
        pageBean = clerkBrandHandleSvc.getListByPage(pageNo);
        return SUCCESS;
    }

    public String save(){
        clerkBrandHandleSvc.saveClerkBrand(getClerkBrand());
        return SUCCESS;
    }

    public String begin(){
        clerkBrandHandleSvc.setClerkStatus(id);
        return SUCCESS;
    }

    public String stop(){
        clerkBrandHandleSvc.setClerkStatus_2(id);
        return SUCCESS;
    }

    public String remove(){
        clerkBrandHandleSvc.remove(id);
        return SUCCESS;
    }

    public String formOpition(){
        pageBean1 = clerkBrandHandleSvc.formClerkOpition(pageNo);
        pageBean2 = clerkBrandHandleSvc.formBrandOpition(pageNo);
        return SUCCESS;
    }



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
}

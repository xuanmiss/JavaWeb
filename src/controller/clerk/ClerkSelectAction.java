package controller.clerk;

import com.opensymphony.xwork2.ActionSupport;
import entity.Clerk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.clerk.IClerkHandleSvc;
import util.PageBean;

/**
 * Created by Administrator on 2017/5/14.
 */
@Controller("selectClerk")
@Scope("prototype")
public class ClerkSelectAction extends ActionSupport {

    @Autowired
    private IClerkHandleSvc clerkSvc;

    int pageNo = 1;
    PageBean<Clerk> pageBean = null;

    @Override
    public String execute(){
        pageBean = clerkSvc.getListByPage(pageNo);
        return SUCCESS;
    }

    public IClerkHandleSvc getClerkSvc() {
        return clerkSvc;
    }

    public void setClerkSvc(IClerkHandleSvc clerkSvc) {
        this.clerkSvc = clerkSvc;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public PageBean<Clerk> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<Clerk> pageBean) {
        this.pageBean = pageBean;
    }
}

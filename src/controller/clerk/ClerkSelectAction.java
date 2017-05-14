package controller.clerk;

import com.opensymphony.xwork2.ActionSupport;
import entity.Clerk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.clerk.IClerkHandlerSvc;
import util.PageBean;

/**
 * Created by Administrator on 2017/5/14.
 */
@Controller("selectClerk")
@Scope("prototype")
public class ClerkSelectAction extends ActionSupport {

    @Autowired
    private IClerkHandlerSvc clerkSvc;

    int pageNo = 1;
    PageBean<Clerk> pageBean = null;

    @Override
    public String execute(){
        pageBean = clerkSvc.getListByPage(pageNo);
        return SUCCESS;
    }
}

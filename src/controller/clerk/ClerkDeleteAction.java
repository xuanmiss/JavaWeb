package controller.clerk;

import com.opensymphony.xwork2.ActionSupport;
import entity.Clerk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.clerk.IClerkHandleSvc;
import service.role.IRoleHandleSvc;

/**
 * Created by Administrator on 2017/5/15.
 */
@Controller("deleteClerk")
@Scope("prototype")
public class ClerkDeleteAction extends ActionSupport{

    @Autowired
    private IClerkHandleSvc clerkSvc;
    @Autowired
    private IRoleHandleSvc roleSvc;

    private int clerkId;

    @Override
    public String execute(){
        //Role role = roleSvc.findByClerk(clerkId);//获取登陆信息
        Clerk clerk = clerkSvc.findById(clerkId);//获取业务员信息
        clerk.setStatus(2);//设置状态为离职
        //roleSvc.deleteById(role.getId());//删除登陆信息
        return "show";
    }

    public int getClerkId() {
        return clerkId;
    }

    public void setClerkId(int clerkId) {
        this.clerkId = clerkId;
    }
}

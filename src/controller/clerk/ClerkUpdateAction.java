package controller.clerk;

import com.opensymphony.xwork2.ActionSupport;
import entity.Clerk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.clerk.IClerkHandleSvc;
import util.StringUtil;

/**
 * Created by Administrator on 2017/5/14.
 */
@Controller("updateClerk")
public class ClerkUpdateAction extends ActionSupport{

    @Autowired
    private IClerkHandleSvc clerkHandleSvc;

    private int clerkId;

    private int update = 0;

    public int getUpdate() {
        return update;
    }

    public void setUpdate(int update) {
        this.update = update;
    }

    private Clerk clerk;

    public int getClerkId() {
        return clerkId;
    }

    public void setClerkId(int clerkId) {
        this.clerkId = clerkId;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public String execute(){
        if(update == 0){
            clerk = clerkHandleSvc.findById(clerkId);
            return "update";
        }
        else{
            check();
            clerkHandleSvc.saveClerk(clerk);
            return "show";
        }
    }

    public void check(){
        update = 0;
        //忽略开始空字符
        clerk.setAddress(clerk.getAddress().trim());
        clerk.setWeichat(clerk.getWeichat().trim());
        clerk.setName(clerk.getName().trim());

        //业务员姓名
        //判断是否为空
        if(StringUtil.isEmptyString(clerk.getName()))
            addFieldError("name", "业务员姓名不能为空！");

    }

}

package controller.clerk;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.clerk.IClerkHandleSvc;

/**
 * Created by Administrator on 2017/5/15.
 */
@Controller("deleteClerk")
public class ClerkDeleteAction extends ActionSupport{

    @Autowired
    private IClerkHandleSvc clerkHandleSvc;

    private int clerkId;

    @Override
    public String execute(){
        clerkHandleSvc.deleteById(clerkId);
        return "show";
    }

    public int getClerkId() {
        return clerkId;
    }

    public void setClerkId(int clerkId) {
        this.clerkId = clerkId;
    }
}

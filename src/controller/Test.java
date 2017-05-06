package controller;

 import com.opensymphony.xwork2.ActionSupport;
 import dao.IClerkDBAccessor;
 import entity.Clerk;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Scope;
 import org.springframework.stereotype.Controller;


/**
 * Created by ymcvalu on 2017/5/6.
 */
@Controller("test")
@Scope("prototype")
public class Test extends ActionSupport {
    private int count=0;
    private String ENTITY="client";

    @Autowired
    private IClerkDBAccessor clerkDBAccessor;

    @Override
    public String execute(){
        Clerk clerk=clerkDBAccessor.getObj(Clerk.class,1);
        count=clerk.getClients().size();
        return SUCCESS;
    }

    public int getCount() {
        return count;
    }
    public String getMsg(){
        return "you hava "+count+" "+ENTITY;
    }
}

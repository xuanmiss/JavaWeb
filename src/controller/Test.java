package controller;

 import com.opensymphony.xwork2.ActionContext;
 import com.opensymphony.xwork2.ActionSupport;
 import dao.IClerkDBAccessor;
 import dao.IClientDBAccessor;
 import entity.Clerk;
 import entity.Client;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Scope;
 import org.springframework.stereotype.Controller;

 import java.util.Map;


/**
 * Created by ymcvalu on 2017/5/6.
 */
@Controller("test")
@Scope("prototype")
public class Test extends ActionSupport {

    @Override
    public String execute(){
        return SUCCESS;
    }


    public String getMsg(){
        Map<String,Object> session=ActionContext.getContext().getSession();
        return "username: "+session.get("username").toString()
                        +" "
                        +"authority: "+session.get("authority")
                        +" "
                        +"clerkID: "+session.get("clerk");

    }
}
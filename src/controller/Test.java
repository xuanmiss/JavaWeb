package controller;

 import com.opensymphony.xwork2.ActionSupport;
 import dao.IClerkDBAccessor;
 import dao.IClientDBAccessor;
 import entity.Clerk;
 import entity.Client;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Scope;
 import org.springframework.stereotype.Controller;


/**
 * Created by ymcvalu on 2017/5/6.
 */
@Controller("test")
@Scope("prototype")
public class Test extends ActionSupport {

    @Autowired
    private IClientDBAccessor clientDBAccessor;

    @Autowired
    private IClerkDBAccessor clerkDBAccessor;

    @Override
    public String execute(){
        return SUCCESS;
    }


    public String getMsg(){
        return "a test page";
    }
}

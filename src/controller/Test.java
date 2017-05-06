package controller;

 import com.opensymphony.xwork2.ActionSupport;
 import dao.IClerkDBAccessor;
 import dao.IClerk_ClientDBAccessor;
 import entity.Clerk;
 import org.springframework.context.annotation.Scope;
 import org.springframework.stereotype.Controller;

 import javax.annotation.Resource;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Controller("test")
@Scope("prototype")
public class Test extends ActionSupport {
    private int count;
    private String ENTITY="client";
    @Resource(name="clerkDBAcc")
    private IClerkDBAccessor clerkAcc;
    @Resource(name = "c_cDBAcc")
    private IClerk_ClientDBAccessor cc;
    @Override
    public String execute(){
        System.out.println(cc.getContractKey(2,2)); 
        Clerk clerk=clerkAcc.getObj( Clerk.class,1);
        clerk.getClients().clear();
        return SUCCESS;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMsg(){
        return "you hava "+count+" "+ENTITY;
    }
}

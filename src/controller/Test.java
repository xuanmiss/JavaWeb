package controller;

 import com.opensymphony.xwork2.ActionSupport;
 import dao.IClerkDBAccessor;
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
    private String ENTITY="clerk";
    @Resource(name="clerkDBAcc")
    private IClerkDBAccessor clerkAcc;

    @Override
    public String execute(){
        count=clerkAcc.getCount(Clerk.class);
        return SUCCESS;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMsg(){
        return "there are "+count+" "+ENTITY;
    }
}

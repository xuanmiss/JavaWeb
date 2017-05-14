package controller.clerk;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2017/5/14.
 */
@Controller("updateClerk")
public class ClerkUpdateAction extends ActionSupport{

    @Override
    public String execute(){
        return "update";
    }

}

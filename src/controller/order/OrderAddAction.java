package controller.order;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.stereotype.Controller;
import service.order.OrderHandler;

/**
 * Created by ymcvalu on 2017/5/21.
 */
@Controller("addOrder")
public class OrderAddAction extends ActionSupport{
    private OrderHandler orderSvc;
    public String requestForAdd(){
        int id= (int)ActionContext.getContext().getSession().get("clerk");

        return SUCCESS;
    }

    public String handlerAddReq(){

        return SUCCESS;
    }

    @Override
    public void validate(){

    }
}

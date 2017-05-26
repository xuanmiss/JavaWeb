package controller.pay;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.pay.IPayServer;

/**
 * Created by ymcvalu on 2017/5/26.
 */

@Controller("pay")
@Scope("prototype")
public class Pay extends ActionSupport {
    private String orderNo;
    private double amount;
    @Autowired
    private IPayServer iPayServer;
    public String requestPay(){
        return "requestsuccess";
    }

    public String handlePay(){
        iPayServer.pay(amount);
        return "handlesuccess";
    }


    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public IPayServer getiPayServer() {
        return iPayServer;
    }

    public void setiPayServer(IPayServer iPayServer) {
        this.iPayServer = iPayServer;
    }
}

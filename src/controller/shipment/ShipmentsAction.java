package controller.shipment;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.stock.IShipmentsSvc;
import util.PageBean;


/**
 * Created by ymcvalu on 2017/5/27.
 */
@Controller("shipments")
@Scope("prototype")
public class ShipmentsAction extends ActionSupport{
    private int pageNo=1;
    private PageBean<Object[]> pageBean;
    private String orderNo;

    @Autowired
    private IShipmentsSvc shipmentsSvc;
    public String showOrder(){
        pageBean=shipmentsSvc.getUndoOrder(pageNo);
        return SUCCESS;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public PageBean<Object[]> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<Object[]> pageBean) {
        this.pageBean = pageBean;
    }

}


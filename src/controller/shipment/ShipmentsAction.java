package controller.shipment;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.stock.IShipmentsSvc;

import java.util.List;

/**
 * Created by ymcvalu on 2017/5/27.
 */
@Controller("shipments")
@Scope("prototype")
public class ShipmentsAction extends ActionSupport{
    private int pageNo=1;
    private List<Object[]> list;
    @Autowired
    private IShipmentsSvc shipmentsSvc;
    public String showOrder(){
        list=shipmentsSvc.getUndoOrder(1);

        return SUCCESS;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<Object[]> getList() {
        return list;
    }

    public void setList(List<Object[]> list) {
        this.list = list;
    }

}


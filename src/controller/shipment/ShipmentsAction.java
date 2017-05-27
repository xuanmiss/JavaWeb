package controller.shipment;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import service.order.OrderHandler;
import service.stock.IShipmentsSvc;
import sun.misc.Contended;

/**
 * Created by ymcvalu on 2017/5/27.
 */
@Contended("shipments")
@Scope("prototype")
public class ShipmentsAction extends ActionSupport{

    @Autowired
    private IShipmentsSvc shipmentsSvc;
    public String showOrder(){

        return SUCCESS;
    }


}

package controller.shipment;

import com.opensymphony.xwork2.ActionSupport;
import entity.Shipment;
import entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.stock.IShipmentsSvc;
import util.PageBean;

import java.util.List;


/**
 * Created by ymcvalu on 2017/5/27.
 */
@Controller("shipments")
@Scope("prototype")
public class ShipmentsAction extends ActionSupport{
    private int pageNo=1;
    private PageBean<Object[]> pageBean;
    private PageBean<Shipment> pageOfShipments;
    private String orderNo;
    private List<Stock> stocks;
    private int stockId;
    private String msg;

    @Autowired
    private IShipmentsSvc shipmentsSvc;
    public String showOrder(){
        pageBean=shipmentsSvc.getUndoOrder(pageNo);
        return SUCCESS;
    }

    public String requestOut(){
        stocks=shipmentsSvc.getBatchesByModelWithQuantityLimit(orderNo);
        return "request";
    }

    public String handleOut(){
        System.out.println(orderNo+":"+stockId);
        boolean flag=shipmentsSvc.handleOut(orderNo,stockId);
        if(flag)
            msg="出库成功!";
        else
            msg="库存不足!";
        return "handle";
    }

    public String selectShipments(){
        //PageBean<Shipment> pageBean = new PageBean<Shipment>();
        pageOfShipments=shipmentsSvc.getListByPage(pageNo);
        System.out.println("fetch size:"+pageOfShipments.getData().size());
        return SUCCESS;
    }

    public PageBean<Shipment> getPageOfShipments() {
        return pageOfShipments;
    }

    public void setPageOfShipments(PageBean<Shipment> pageOfShipments) {
        this.pageOfShipments = pageOfShipments;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}


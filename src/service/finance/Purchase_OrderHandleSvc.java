package service.finance;

import dao.IPurchaseOrderDBAccessor;
import entity.Purchase_Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PageBean;

/**
 * Created by chenshihong on 2017/5/21.
 */
@Service
public class Purchase_OrderHandleSvc implements IPurchaseOrderHandleSvc{
    @Autowired
    private IPurchaseOrderDBAccessor purchaseOrderDBAcc;
    @Override
    public PageBean<Purchase_Order> getListByPage(int pageNo) {
        PageBean<Purchase_Order> pb=new PageBean<>();
        pb.setCurPage(pageNo);
        pb.setMaxRowCount(purchaseOrderDBAcc.getCount(Purchase_Order.class));
        pb.setData(purchaseOrderDBAcc.getListByPageOrderByDate(pageNo,pb.getRowsPerPage()));
        return pb;
    }



    @Override
    public void setPurchaseOrderType(Purchase_Order order) {
        purchaseOrderDBAcc.setPurchaseOrderType(order);
    }

    @Override
    public Purchase_Order findById(int id) {
        return purchaseOrderDBAcc.getObj(Purchase_Order.class,id);
    }

    @Override
    public void updatePurchaseOrder(Purchase_Order order) {
        purchaseOrderDBAcc.update(order);
    }


}

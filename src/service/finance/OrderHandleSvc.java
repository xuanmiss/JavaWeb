package service.finance;

import dao.IModelDBAccessor;
import dao.IOrderDBAccessor;
import entity.Model;
import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.brand.IModelHandleSvc;
import util.PageBean;

/**
 * Created by chenshihong on 2017/5/17.
 */

@Service
public class OrderHandleSvc implements IOrderHandleSvc {
    @Autowired
    private IOrderDBAccessor orderDbAcc;
    @Autowired
    private IModelDBAccessor modelDbAcc;
    @Override
    public PageBean<Order> getPageListOrder(int pageNo) {
        PageBean<Order> pb=new PageBean<>();
        pb.setCurPage(pageNo);
        pb.setMaxRowCount(orderDbAcc.getCount(Order.class));
        //pb.setData(orderDbAcc.getListByPage(Order.class,pageNo,pb.getRowsPerPage()));
        pb.setData(orderDbAcc.getListByPageOrderByDate(pageNo,pb.getRowsPerPage()));
        return pb;
    }

    @Override
    public PageBean<Order> getPageListClerkOrder(int clerkId, int pageNo) {
        PageBean<Order> pb=new PageBean<>();
        pb.setCurPage(pageNo);
        pb.setMaxRowCount(orderDbAcc.getCountOfClerkOrder(clerkId));
        pb.setData(orderDbAcc.getListByPageClerkOrder(clerkId,pageNo,pb.getRowsPerPage()));
        return pb;
    }

    @Override
    public PageBean<Order> getPageListModelOrder(int modelId, int pageNo) {
        PageBean<Order> pb = new PageBean<>();
        pb.setCurPage(pageNo);
        pb.setMaxRowCount(orderDbAcc.getCountOfOrderModel(modelId));
        pb.setData(orderDbAcc.getListByPageModelOrder(modelId,pageNo,pb.getRowsPerPage()));
        return pb;
    }
}

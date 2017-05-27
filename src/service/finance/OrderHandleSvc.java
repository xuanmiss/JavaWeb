package service.finance;

import dao.IOrderDBAccessor;
import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PageBean;

/**
 * Created by chenshihong on 2017/5/17.
 */

@Service
public class OrderHandleSvc implements IOrderHandleSvc {
    @Autowired
    private IOrderDBAccessor orderDbAcc;
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
}

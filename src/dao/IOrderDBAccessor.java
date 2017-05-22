package dao;

import entity.Order;

import java.util.List;
import java.util.Map;

/**
 * Created by LCQ on 2017/5/7.
 */
public interface IOrderDBAccessor extends IBaseDBAccessor<Order>{
    /**
     *
     *按日期排序获取分页
     */
    List<Order> getListByPageOrderByDate(int pageNo,int rows);

    int getCountOfOrder(int state);
    List<Order> getListByPage(int state,int pageNo,int rows);
    int getCountOfOrder(int clerk,int state);
    List<Order> getListByPage(int clerk,int state,int pageNo,int rows);
    List<Order> getClerkOrders(int clerk,int pageNo,int rows);
    int getCountOfClerkOrder(int clerk);
    boolean hasOrderByClerk(int id);
    boolean hasOrderByClient(int id);
    List undoneOrders(int pageNo,int rows);
}

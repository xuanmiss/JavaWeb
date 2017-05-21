package dao;

import entity.Order;

import java.util.List;

/**
 * Created by LCQ on 2017/5/7.
 */
public interface IOrderDBAccessor extends IBaseDBAccessor<Order>{
    int getCountOfOrder(int state);
    List<Order> getListByPage(int state,int pageNo,int rows);
    int getCountOfOrder(int clerk,int state);
    List<Order> getListByPage(int clerk,int state,int pageNo,int rows);
    List<Order> getClerkOrders(int clerk,int pageNo,int rows);
    int getCountOfClerkOrder(int clerk);
    boolean hasOrderByClerk(int id);
    boolean hasOrderByClient(int id);
}

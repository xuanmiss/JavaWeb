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
    List<Order> getListByPageOrderByDate(int pageNo, int rows);
    List<Order> getListByPageClerkOrder(int clerkId, int pageNo, int rows);
    List<Order> getListByPageModelOrder(int modelId, int pageNo, int rows);
    int getCountOfOrder(int state);
    List<Order> getListByPage(int state, int pageNo, int rows);
    int getCountOfOrder(int clerk, int state);
    List<Order> getListByPage(int clerk, int state, int pageNo, int rows);
    List<Order> getClerkOrders(int clerk, int pageNo, int rows);

    List<Order> getListByPage(int clerk,int client,int state,int pageNo,int rows);
    List<Order> getLIstByClerkAndClient(int clerk,int client,int pageNo,int rows);
    List<Order> getListByClient(int client,int state,int pageNo,int rows);
    List<Order> getListByClient(int client,int pageNo,int rows);
    int getCountByClerkAndClientAndState(int clerk,int client,int state);
    int getCountByClerkAndClient(int clerk,int client);
    int getCountByClinetANdState(int client,int state);
    int getCountByClient(int client);


    int getCountOfClerkOrder(int clerk);
    int getCountOfOrderModel(int model);
    boolean hasOrderByClerk(int id);
    boolean hasOrderByClient(int id);
    List<Object[]> undoneOrders(int pageNo, int rows);
    boolean hasOrder(String orderNO);
    Order getOrder(String orderNo);
}

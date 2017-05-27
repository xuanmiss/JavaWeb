package service.finance;

import entity.Order;
import util.PageBean;

/**
 * Created by chenshihong on 2017/5/17.
 */
public interface IOrderHandleSvc {
    PageBean<Order> getPageListOrder(int pageNo);
    PageBean<Order> getPageListClerkOrder(int clerkId,int pageNo);
    PageBean<Order> getPageListModelOrder(int modelId,int pageNo);
}

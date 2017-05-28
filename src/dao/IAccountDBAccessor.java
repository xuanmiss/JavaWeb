package dao;

import entity.Account;

/**
 * Created by miss on 2017/5/6.
 */

/**
 * 公司账户接口
 */
public interface IAccountDBAccessor extends IBaseDBAccessor<Account>{
    /**
     * 声明新方法
     * ...
     */
    boolean purchaseOrder(double purchase_orderAmount);
    void increaseAccount(double amount);
}

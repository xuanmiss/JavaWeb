package service.finance;

import entity.Account;
import entity.AccountFlow;
import entity.Purchase_Order;
import util.PageBean;

/**
 * Created by chenshihong on 2017/5/20.
 */
public interface IAccountHandleSvc {
    Account getAccount();
    PageBean<AccountFlow> getListByPage(int pageNo);
    boolean purchaseOrderAmount(double amount);
    void increaseAccount(double amount);
    void updateAccont(Account account);
    void insertAccountFlowByArrears(AccountFlow arrears);
    void insertAccountFlowByOrder(Purchase_Order order);
    AccountFlow getAccountFlowById(int AccountFlowId);

}

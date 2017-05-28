
package dao;

import entity.Account;
import entity.Clerk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * Created by miss on 2017/5/6.
 */

/**
 * 公司账户实现类
 */
@Repository("accountDBAcc")
@Lazy
public class AccountDBAccessor extends BaseDBAccessor<Account> implements IAccountDBAccessor{
    /**
     * 声明新方法
     * ...
     *
     * @param purchase_orderAmount
     *          进货单编号
     */
    @Override
    public boolean purchaseOrder(double purchase_orderAmount) {
        Account account = getObj(Account.class,1);
        double remainAmount = account.getFixed() - purchase_orderAmount;
        if(remainAmount > 0){
            account.setFixed(remainAmount);
            return  true;
        }
        else{
            return false;
        }
    }
    //账户收款
    @Override
    public void increaseAccount(double amount) {
        Account account = getObj(Account.class,1);
        double newFlow = account.getFlow()+amount;
        account.setFlow(newFlow);
    }

    /**
     * 在这里实现新方法...
     */
}


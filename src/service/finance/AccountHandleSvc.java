package service.finance;

import dao.IAccountDBAccessor;
import dao.IAccountFlowDBAccessor;
import entity.Account;
import entity.AccountFlow;
import entity.Purchase_Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PageBean;

import java.util.Date;

/**
 * Created by chenshihong on 2017/5/20.
 */
@Service
public class AccountHandleSvc implements IAccountHandleSvc{
    @Autowired
    private IAccountDBAccessor accountDBAcc;

    @Autowired
    private IAccountFlowDBAccessor accountFlowDBAcc;
    @Override
    public Account getAccount() {
        return accountDBAcc.getObj(Account.class,1);
    }

    @Override
    public PageBean<AccountFlow> getListByPage(int pageNo) {
        PageBean<AccountFlow> pb=new PageBean<>();
        pb.setCurPage(pageNo);
        pb.setRowsPerPage(10);
        pb.setMaxRowCount(accountFlowDBAcc.getCount(AccountFlow.class));
        pb.setData(accountFlowDBAcc.getListByPageOrderByDate(pageNo,pb.getRowsPerPage()));
        return pb;
    }

    @Override
    public boolean purchaseOrderAmount(double amount) {
        if(accountDBAcc.purchaseOrder(amount))
            return  true;
        else
            return false;
    }

    @Override
    public void increaseAccount(double amount) {
        accountDBAcc.increaseAccount(amount);
    }

    @Override
    public void updateAccont(Account account) {
        accountDBAcc.update(account);
    }

    @Override
    public void insertAccountFlowByArrears(AccountFlow arrears) {
        AccountFlow accountFlow = new AccountFlow();
        accountFlow.setAmount(Math.abs(arrears.getAmount()));
        accountFlow.setClerk(arrears.getClerk());
        accountFlow.setDescription("客户订单还款收入");
        accountFlow.setType(2);
        accountFlow.setDate(new Date());
        accountFlow.setOrder_no(arrears.getOrder_no());
        accountFlowDBAcc.insert(accountFlow);
    }

    @Override
    public void insertAccountFlowByOrder(Purchase_Order order) {
        AccountFlow accountFlow = new AccountFlow();
        accountFlow.setAmount(-order.getAmount());
        accountFlow.setClerk(order.getClerk());
        accountFlow.setDescription("订货支出");
        accountFlow.setType(1);
        accountFlow.setOrder_no(order.getId());
        accountFlow.setDate(new Date());
        accountFlowDBAcc.insert(accountFlow);
    }

    @Override
    public AccountFlow getAccountFlowById(int AccountFlowId) {
        return accountFlowDBAcc.getAccountFlowById(AccountFlowId);
    }
}

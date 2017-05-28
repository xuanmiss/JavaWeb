package controller.finance;

import com.opensymphony.xwork2.ActionSupport;
import dao.IAccountDBAccessor;
import dao.IAccountFlowDBAccessor;
import entity.Account;
import entity.AccountFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.finance.IAccountHandleSvc;
import service.finance.IArrearHandleSvc;
import util.PageBean;

/**
 * Created by chenshihong on 2017/5/20.
 */
@Controller("account")
@Scope("request")
public class AccountAction extends ActionSupport{
    @Autowired
    private IAccountHandleSvc accountSvc;
    @Autowired
    private IArrearHandleSvc arrearSvc;

    private PageBean<AccountFlow> pageBean;
    private Account account;
    private int accountFlowId;
    private int pageNo = 1;
    private AccountFlow accountFlow;
    private double amount;
    @Override
    public String execute(){
        pageBean = accountSvc.getListByPage(pageNo);
        account = accountSvc.getAccount();
        return SUCCESS;
    }
    public String loadAccountFlow(){
        accountFlow = accountSvc.getAccountFlowById(accountFlowId);
        amount = Math.abs(accountFlow.getAmount());
        return SUCCESS;
    }

    //客户白条付款操作
    public String accountPayArrears(){
        AccountFlow arrears = accountSvc.getAccountFlowById(accountFlowId);
        accountSvc.insertAccountFlowByArrears(arrears);
        accountSvc.increaseAccount(Math.abs(arrears.getAmount()));
        arrearSvc.deleteArrear(arrears);
        //设置类型为客户白条已还款
        arrears.setType(5);
        return SUCCESS;
    }

    public IAccountHandleSvc getAccountSvc() {
        return accountSvc;
    }

    public void setAccountSvc(IAccountHandleSvc accountSvc) {
        this.accountSvc = accountSvc;
    }

    public PageBean<AccountFlow> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<AccountFlow> pageBean) {
        this.pageBean = pageBean;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getAccountFlowId() {
        return accountFlowId;
    }

    public void setAccountFlowId(int accountFlowId) {
        this.accountFlowId = accountFlowId;
    }

    public AccountFlow getAccountFlow() {
        return accountFlow;
    }

    public void setAccountFlow(AccountFlow accountFlow) {
        this.accountFlow = accountFlow;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

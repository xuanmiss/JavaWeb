package controller.finance;

import com.opensymphony.xwork2.ActionSupport;
import dao.IAccountDBAccessor;
import dao.IAccountFlowDBAccessor;
import entity.Account;
import entity.AccountFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.finance.IAccountHandleSvc;
import util.PageBean;

/**
 * Created by chenshihong on 2017/5/20.
 */
@Controller("account")
public class AccountAction extends ActionSupport{
    @Autowired
    private IAccountHandleSvc accountSvc;

    private PageBean<AccountFlow> pageBean;
    private Account account;
    private int pageNo = 1;

    @Override
    public String execute(){
        pageBean = accountSvc.getListByPage(pageNo);
        account = accountSvc.getAccount();
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
}

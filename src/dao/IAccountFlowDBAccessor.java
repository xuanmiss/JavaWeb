package dao;


import entity.AccountFlow;
import util.PageBean;

import java.util.List;
/**
 * Created by miss on 2017/5/6.
 */

/**
 * 流水账户接口
 */
public interface IAccountFlowDBAccessor extends IBaseDBAccessor<AccountFlow>{
    /**
     * 声明新方法
     * ...
     */
    //按时间顺序获取分页
    List<AccountFlow> getListByPageOrderByDate(int pageNo, int rows);
    AccountFlow getAccountFlowById(int id);
}

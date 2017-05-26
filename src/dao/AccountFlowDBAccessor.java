package dao;


import entity.AccountFlow;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by chenshihong on 2017/5/26.
 */
@Controller("accountFlowDBAcc")
public class AccountFlowDBAccessor extends BaseDBAccessor<AccountFlow> implements IAccountFlowDBAccessor{
    /**
     * 声明新方法
     * ...
     *
     * @param pageNo
     * @param rows
     */
    @Override
    public List<AccountFlow> getListByPageOrderByDate(int pageNo, int rows) {
        return getSession().createQuery("from entity.AccountFlow order by date")
                .setFirstResult((pageNo-1)*rows)
                .setMaxResults(rows)
                .list();
    }
}

package dao;

import entity.AccountFlow;
import entity.Clerk;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by miss on 2017/5/6.
 */

/**
 * 账户流水实现类
 */
@Repository("accoutFlowDBAcc")
@Lazy
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

    /**
     * 在这里实现新方法...
     */

}

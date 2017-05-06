package dao;

import entity.AccountFlow;
import entity.Clerk;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

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
     * 在这里实现新方法...
     */

}


package dao;

import entity.Account;
import entity.Clerk;
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
     * 在这里实现新方法...
     */
}


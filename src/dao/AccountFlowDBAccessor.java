package dao;

import entity.Clerk;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * Created by miss on 2017/5/6.
 */
public class AccountFlowDBAccessor {
    @Repository("accoutflowDBAcc")
    @Lazy
    public class ClerkDBAccessor extends BaseDBAccessor<Clerk> implements IClerkDBAccessor {
        /**
         * 在这里实现新方法...
         */
    }
}

package dao;

import entity.Clerk;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * Created by ymcvalu on 2017/5/4.
 */

/**
 * 员工表访问实现类
 */
@Repository("clerkDBAcc")
@Lazy
public class ClerkDBAccessor extends BaseDBAccessor<Clerk> implements IClerkDBAccessor {
    /**
     * 实现新方法...
     */
}
